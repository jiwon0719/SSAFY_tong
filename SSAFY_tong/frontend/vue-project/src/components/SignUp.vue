<template>
  <div class="signup-form">
    <router-link to="/main">
        <div class="tong" style="text-decoration: none;">TONG</div>
    </router-link>
      
    <div v-if="!userStore.getKakaoUserInfo">
  <div class="id-input-container">
    <label>아이디</label>
    <div class="id-input-wrapper">
      <input  
        v-model="userId" 
        placeholder="영문, 숫자 조합 4-20자" 
        :class="{ 'invalid': userId && !isUserIdValid }"
        class="id-input"
        @input="isIdChecked = false"  
      />
      <button 
        @click="checkUserIdDuplicate" 
        class="duplicate-check-btn"
      >
        {{ isIdChecked ? '확인완료' : '중복검사' }}
      </button>
    </div>
  </div>
</div>


<!-- 사용자 정보가 있으면 화면에 보이지 않음 -->
<div v-if="userStore.getKakaoUserInfo" style="display:none">
  <!-- 내부적으로는 사용됨 -->
  <input v-model="userId" type="hidden"/>
</div>

    <div>
      <label>비밀번호</label>
      <input 
        type="password" 
        v-model="password" 
        placeholder="영문, 숫자, 특수문자 포함 8자 이상" 
        :class="{ 'invalid': password && passwordError }"
      />
      <div v-if="passwordError" class="invalid-feedback">
        {{ passwordError }}
      </div>
    </div>

    <div>
      <label>비밀번호 확인</label>
      <input 
        type="password" 
        v-model="passwordConfirm" 
        placeholder="비밀번호 확인"
        :class="{ 'invalid': passwordConfirm && !passwordMatch }"
      />
      <div v-if="passwordConfirm" :class="passwordMatchClass">
        {{ passwordMatch }}
      </div>
    </div>

    <!-- 이름 필드 -->
<div>
  <label>이름</label>
  <input 
    v-model="name" 
    placeholder="이름을 입력하세요"
    :disabled="!!userStore.getKakaoUserInfo"
  />
</div>


 
<!-- 이메일 입력 필드 -->
<div class="email-input">
  <label>이메일</label>
  <input 
    v-model="email" 
    placeholder="이메일 입력"
    :disabled="!!userStore.getKakaoUserInfo"
  />
  <span>@</span>
  <select 
    v-model="emailDomain" 
    @change="handleDomainChange"
    :disabled="!!userStore.getKakaoUserInfo"
  >
    <option value="gmail.com">gmail.com</option>
    <option value="naver.com">naver.com</option>
    <option value="daum.net">daum.net</option>
    <option value="ssafy.com">ssafy.com</option>
    <option value="text">직접입력</option>
  </select>
  
  <input 
    v-if="emailDomain === 'text'" 
    v-model="customDomain" 
    placeholder="직접 입력한 도메인"
    :disabled="!!userStore.getKakaoUserInfo"
  />
</div>

    <div class="phone-input">
      <label>전화번호</label>
      <select v-model="phoneFirst">
        <option value="010">010</option>
        <option value="011">011</option>
        <option value="011">017</option>
      </select>
      <input v-model="phoneMiddle" placeholder="****" maxlength="4" />
      <input v-model="phoneLast" placeholder="****" maxlength="4" />
    </div>

    <div>
      <label>생일</label>
      <input type="date" v-model="birthdate" />
    </div>

    <div>
      <label>우편번호</label>
      <input v-model="zipcode" placeholder="우편번호" readonly />
      <button @click="openPostcode">우편번호 찾기</button>
    </div>

    <div>
      <label>주소</label>
      <input v-model="address" placeholder="기본 주소" readonly />
    </div>

    <div>
      <label>상세 주소</label>
      <input v-model="addressDetail" id="addressDetail" placeholder="상세 주소 입력" />
    </div>

    <div>
      <label>회원 유형</label>
      <select v-model="userType">
        <option value='U'>일반회원</option>
        <option value='E'>전문가회원</option>
      </select>
    </div>

    <button @click="registerUser">회원가입</button>
  </div>
</template>

<style scoped>

.signup-form {
  width: 800px;
  margin: 0 auto; /* 중앙 정렬 */
  padding: 20px;
  background-color: #f9f9f9;
  border: 1px solid #ddd;
  border-radius: 10px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  position: relative;
  text-decoration:none;
  
}
.tong {
  margin: 0 auto; /* 중앙 정렬 */
  z-index: 2;
  width: 190px;
  height: 134px;
  color: #E2495B;
  white-space: nowrap;
  font-family: "Jockey One";
  font-size: 96px;
  line-height: 134px;
  transition: transform 0.3s ease;
  text-decoration:none;
}

.tong:hover {
  transform: scale(1.05);
  text-decoration:none;
}

a {
    text-decoration: none;
}


.id-input-container {
  position: relative;
}

.id-input-wrapper {
  display: flex;
  align-items: center;
  gap: 10px;
}

.id-input {
  display: flex;
  align-items: center; /* 수직 중앙 정렬 */
  gap: 10px;
}

.duplicate-check-btn {
  width: auto; /* Allow button to size to content */
  padding: 10px;
  margin-top: -15px;
  flex-shrink: 0; /* Prevent button from shrinking */

  background: linear-gradient(to right, #dc606f 0%, #e2495b 100%);
    background-size: 200% auto; /* 배경 크기 조정 */
    transition: all 0.3s ease, background-position 0.5s ease;

    &:hover {
    background-position: right center; /* 배경이 오른쪽으로 이동 */
    background-image: linear-gradient(to right, #fbc2eb 0%, #a6c1ee 51%, #fbc2eb 100%);
  }

}

/* Responsive adjustments */
@media (max-width: 500px) {
  .id-input-wrapper {
    flex-direction: column;
    gap: 10px;
  }
  
  .duplicate-check-btn {
    width: 100%;
  }
}


/* 추가된 유효성 검사 관련 스타일 */
.invalid {
  border-color: #dc3545 !important;
}

.invalid-feedback {
  color: #dc3545;
  font-size: 0.875rem;
  margin-top: -10px;
  margin-bottom: 10px;
}

.valid-feedback {
  color: #28a745;
  font-size: 0.875rem;
  margin-top: -10px;
  margin-bottom: 10px;
}

/* 나머지 기존 스타일 유지 */
h2 {
  text-align: center;
  color: #333;
  margin-bottom: 20px;
}

input, select {
  display: block;
  width: 100%;
  padding: 10px;
  margin-bottom: 15px;
  font-size: 14px;
  border: 1px solid #ccc;
  border-radius: 5px;
  transition: border-color 0.3s;
}

input:focus, select:focus {
  border-color: #E2495B;
  outline: none;
}

button {
  width: 100%;
  padding: 12px;
  background-color: #E2495B;
  color: #fff;
  border: none;
  border-radius: 5px;
  font-size: 16px;
  cursor: pointer;
  transition: background-color 0.3s;
  margin-top: 10px;


  background: linear-gradient(to right, #dc606f 0%, #e2495b 100%);
    background-size: 200% auto; /* 배경 크기 조정 */
    transition: all 0.3s ease, background-position 0.5s ease;

    &:hover {
    background-position: right center; /* 배경이 오른쪽으로 이동 */
    background-image: linear-gradient(to right, #fbc2eb 0%, #a6c1ee 51%, #fbc2eb 100%);
    }
}
/* 
button:hover {
  background-color: #ff001e;
} */

.email-input {
  display: flex;
  align-items: center;
  gap: 10px; /* 요소들 간의 간격을 조정 */
}

.email-input input {
  width: 30%; /* 첫 번째 이메일 입력 필드의 너비 */
  margin-right: 10px;
  
}

.email-input select {
  width: 30%; /* 선택박스의 너비 */
}

.email-input label {
  flex: 0 0 50px; /* label 너비를 지정 (80px로 설정) */
  margin-right: 10px;
  font-size: 16px;
  text-align: right; /* 텍스트를 오른쪽 정렬하여 이메일 입력 필드와 잘 정렬되게 함 */
}

.email-input input[type="text"] {
  width: 30%; /* '직접입력' 필드가 나타날 때의 스타일 */
}

.email-input input[type="text"]:not([v-model="customDomain"]) {
  width: 25%; /* 기본 입력필드의 너비 */
}

.email-input span {
  font-size: 16px;
}

.phone-input {
  display: flex;
  gap: 5px;
}

.phone-input select,
.phone-input input {
  flex: 1;
}

#addressDetail {
  margin-top: 10px;
}

@media (max-width: 500px) {
  .signup-form {
    padding: 15px;
  }

  input, select, button {
    font-size: 14px;
  }

  .phone-input {
    flex-direction: column;
  }

  .phone-input select,
  .phone-input input {
    width: 100%;
    margin-bottom: 5px;
  }
}
</style>


<script setup>
import { ref, computed, onMounted} from 'vue';
import axios from 'axios';
import { useRouter } from "vue-router";
import { useUserStore } from '@/stores/user'; // UserStore import 추가

const router = useRouter();
const userStore = useUserStore(); // UserStore 인스턴스 생성

const userId = ref('');
const isIdChecked = ref(false);  // 아이디 중복 확인 상태 추가
const password = ref('');
const passwordConfirm = ref('');
const name = ref('');
const email = ref('');
const emailDomain = ref('gmail.com');
const customDomain = ref('');
const address = ref('');
const zipcode = ref('');
const addressDetail = ref('');
const userType = ref('U');
const birthdate = ref('');
const phoneFirst = ref('010');
const phoneMiddle = ref('');
const phoneLast = ref('');
const userProfileImgPath = ref('data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMwAAADACAMAAAB/Pny7AAAAHlBMVEX5vfHwpeb6vPLyrerwp+f4ufD0sOz2tO7yqun2tu5u9qVmAAACfElEQVR4nO3aC5KjMAxF0eA/+9/wAElmOh0CImNKEnXPCnhlWbaxbzcAAAAAAAAAAAAAAAAAAABAWZhpf0QPIddaYpnUMftOlGtsaXhILdas/UVfy7ENv7TiM04u6XeUJU51WGz1bVT+xvE2OKF8ijJPHl+Ds5nFWZqdLHMa7U+UqztZJm7SjKtt7JWXLhA+9rGXNNqfKbM3YR6K9ndKZEGRuSk04cC4GJosmjHL0NhfbARt+SGN2t+6J0RxGPt1Jq+yYYjW60yyYD6Z72f1SmHWT2TrzG83CWOVeP33EOZIA7hUmGZ9C3CpdebQDsB6mEvtzY7smq3Pf/lB08V5Rl5n9qvsYv8ALvV35hZEQ+NgxiwkDS25KLKZoNDst+Wn/Y5WnBTZLMTteeMpy3w3u5Em+coyjc3Hs0BqfubLUxjXByf5vDwPtb3FSdHTdeaLPJafeVIro9coizzWEltrMfp/PLMIl3nWBAAwJdxCnlbNu3FeM30uN/eV/22bOW0Fpp2An0QhzG9mt45maWil5pv5SFOQIvt1nmLJposujMIk9zjTMc3s1vPTcWzLdCjQ/uxVh0blZxx7J8/8XZQljrXD53jgjumdrSu08etheQyOnZkTjrxkWGfmFq1DFjOP0LtksTI2R54xbKYxMG/kF7J79O8F83/15FdRO0yfCfOgXGhHXpfsU77n7Fhkg3ZH6zswyj2g64wZdIemZyu7U3y33Wu9/Eexzo68LhVSq7MjD+Wk1C6ie/eymdqkkT/6k1ObNGeEUds7nxJGqQOcMf/VOsClwvRf/zXDnNCZ1XpzLi32p/d8K5xAKwsAAAAAAAAAAAAAAAAAAFD2B3vkGDsXKoABAAAAAElFTkSuQmCC');

onMounted(async () => {
  loadDaumPostcodeScript();
  
  // 카카오 토큰 확인
  const kakaoToken = userStore.kakaoToken;
  console.log("kakaoToken:", kakaoToken);
  console.log("Initial kakaoUserInfo:", userStore.getKakaoUserInfo); 

  if (kakaoToken) {
    // 카카오 유저 정보 가져오기
    await userStore.fetchUserInfo();
    const kakaoUserInfo = userStore.getKakaoUserInfo;
    console.log("kakaoUserInfo after fetch:", kakaoUserInfo);
    
    if (kakaoUserInfo) {

      console.log("kakaoUserInfo :",kakaoUserInfo);

      // 아이디 설정 (카카오 ID 사용)
      userId.value = kakaoUserInfo.kakaoId;

      console.log(userId.value);
      
      // 이름 설정 (카카오 닉네임 사용)
      name.value = kakaoUserInfo.nickname;
      
      // 이메일 처리
      if (kakaoUserInfo.email) {
        const [emailId, domain] = kakaoUserInfo.email.split('@');
        email.value = emailId;
        
        // 도메인 처리
        const knownDomains = ['ssafy.com', 'naver.com', 'daum.net', 'gmail.com'];
        if (knownDomains.includes(domain)) {
          emailDomain.value = domain;
        } else {
          emailDomain.value = 'text';
          customDomain.value = domain;
        }
      }
      
      // 프로필 이미지 설정
      if (kakaoUserInfo.profileImage) {
        userProfileImgPath.value = kakaoUserInfo.profileImage;
      }
    }
  }
});

// 아이디 유효성 검사 (computed)
const isUserIdValid = computed(() => {
  const regex = /^(?=.*[a-zA-Z])(?=.*\d)[a-zA-Z\d!@#$%^&*()_+={}\[\]:;"'<>,.?/\\|-]{4,20}$/;
  const result = regex.test(userId.value);

  // 개발 환경에서만 출력할 수 있도록 조건 추가
  if (process.env.NODE_ENV === 'development') {
    console.log('Validation check:', {
      userId: userId.value,
      isValid: result,
      regexUsed: regex.toString()
    });
  }

  return result;
});



const passwordError = computed(() => {
  if (!password.value) return '비밀번호를 입력해주세요.';
  if (password.value.length < 8) return '비밀번호는 8자 이상이어야 합니다.';
  if (!/^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*])[a-zA-Z\d!@#$%^&*]{8,}$/.test(password.value)) {
    return '비밀번호는 영문, 숫자, 특수문자를 모두 포함해야 합니다.';
  }
  return '';
});

const passwordMatch = computed(() => {
  if (!passwordConfirm.value) return '';
  return password.value === passwordConfirm.value ? '비밀번호가 일치합니다.' : '비밀번호가 일치하지 않습니다.';
});

const passwordMatchClass = computed(() => {
  if (!passwordConfirm.value) return '';
  return password.value === passwordConfirm.value ? 'valid-feedback' : 'invalid-feedback';
});

// Daum 주소 API 스크립트 로드
const loadDaumPostcodeScript = () => {
  const script = document.createElement('script');
  script.src = "//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js";
  script.async = true;
  document.head.appendChild(script);
};

const openPostcode = () => {
  new window.daum.Postcode({
    oncomplete: function (data) {
      let addr = ''; 
      let extraAddr = ''; 

      if (data.userSelectedType === 'R') {
        addr = data.roadAddress;
      } else {
        addr = data.jibunAddress;
      }

      if (data.userSelectedType === 'R') {
        if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
          extraAddr += data.bname;
        }
        if (data.buildingName !== '' && data.apartment === 'Y') {
          extraAddr += extraAddr !== '' ? ', ' + data.buildingName : data.buildingName;
        }
        if (extraAddr !== '') {
          extraAddr = ' (' + extraAddr + ')';
        }
      }

      zipcode.value = data.zonecode;
      address.value = addr + extraAddr;
      document.getElementById('addressDetail').focus();
    },
  }).open();
};


// 회원가입
const registerUser = async () => {
  // 유효성 검사
  if (!isUserIdValid.value) {
    alert('아이디는 영문과 숫자를 조합하여 4-20자로 입력해주세요.');
    return;
  }

  if (passwordError.value) {
    alert(passwordError.value);
    return;
  }

  if (password.value !== passwordConfirm.value) {
    alert('비밀번호가 일치하지 않습니다.');
    return;
  }

  if (
    !userId.value || 
    !password.value || 
    !name.value || 
    !email.value || 
    !phoneMiddle.value || 
    !phoneLast.value ||
    !address.value
  ) {
    alert('모든 필드를 올바르게 입력해주세요.');
    return;
  }



  const userData = {
    userId: userId.value,
    password: password.value,
    name: name.value,
    email: `${email.value}@${emailDomain.value === 'text' ? customDomain.value : emailDomain.value}`,
    phone: `${phoneFirst.value}${phoneMiddle.value}${phoneLast.value}`,
    addressZipcode: zipcode.value,
    address: address.value,
    addressDetail: addressDetail.value,
    userType: userType.value,
    birthdate: birthdate.value,
    userProfileImgPath: userProfileImgPath.value,
  };


try {
  // POST 요청을 보내서 회원가입 진행
  const response = await axios.post('http://localhost:8080/api/user/signUp', userData, {
    headers: {
      'Content-Type': 'application/json', // ensure Content-Type header is set correctly
    }
  });

  console.log(response);


  if (response.status === 201) {
    alert('회원가입이 완료되었습니다!');
    router.push("/signIn");
  } else {
    alert('회원가입에 실패했습니다.');
  }
} catch (error) {
  console.error('회원가입 오류:', error);
  alert('회원가입 중 오류가 발생했습니다.');
}
};


// 아이디 중복검사 체크
const checkUserIdDuplicate = async () => {
  // 1. 유효성 검사
  if (!isUserIdValid.value) {
    alert('아이디 형식이 유효하지 않습니다. 올바른 형식을 입력해주세요.');
    return;
  }

  // 2. 중복 검사 (서버 요청 등)
  try {
    const response = await axios.get(`http://localhost:8080/api/user/checkUserIdDuplicate?userId=${userId.value}`);
    if (response.data.duplicate) {
      alert('이미 사용 중인 아이디입니다.');
      isIdChecked.value = false;
    } else {
      alert('사용 가능한 아이디입니다.');
      isIdChecked.value = true;
    }
  } catch (error) {
    console.error('아이디 중복 검사 중 오류 발생:', error);
    alert('아이디 중복 검사에 실패했습니다.');
    isIdChecked.value = false;
  }
};



</script>