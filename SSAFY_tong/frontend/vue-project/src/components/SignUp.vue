

<template>
  <div class="signup-form">
    <router-link to="/main">
        <div class="tong" style="text-decoration: none;">TONG</div>
    </router-link>
      
      <div>
      <label>아이디</label>
      <input 
        v-model="userId" 
        placeholder="영문, 숫자 조합 4-20자" 
        :class="{ 'invalid': userId && !isUserIdValid }"
      />
      <div v-if="userId && !isUserIdValid" class="invalid-feedback">
        아이디는 영문과 숫자를 조합하여 4-20자로 입력해주세요.
      </div>
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

    <!-- 나머지 템플릿 코드는 동일 -->
    <div>
      <label>이름</label>
      <input v-model="name" placeholder="이름을 입력하세요" />
    </div>

    <div class="email-input">
    <label sy>이메일</label>
    <input v-model="email" placeholder="이메일 입력" />
    <span>@</span>

    <!-- 이메일 도메인 선택 -->
    <select v-model="emailDomain" @change="handleDomainChange">
      <option value="gmail.com">gmail.com</option>
      <option value="naver.com">naver.com</option>
      <option value="daum.net">daum.net</option>
      <option value="ssafy.com">ssafy.com</option>
      <option value="text">직접입력</option>
    </select>

    <!-- '직접입력' 선택시, 도메인 입력 필드 표시 -->
    <input 
      v-if="emailDomain === 'text'" 
      v-model="customDomain" 
      placeholder="직접 입력한 도메인" 
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
}

button:hover {
  background-color: #ff001e;
}

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

const router = useRouter();


const userId = ref('');
const password = ref('');
const passwordConfirm = ref('');
const name = ref('');
const email = ref('');
const emailDomain = ref('gmail.com');
const address = ref('');
const zipcode = ref('');
const addressDetail = ref('');
const userType = ref('basic');
const birthdate = ref('');
const phoneFirst = ref('010');
const phoneMiddle = ref('');
const phoneLast = ref('');

// 유효성 검사를 위한 computed 속성들
const isUserIdValid = computed(() => {
  const regex = /^(?=.*[a-zA-Z])(?=.*\d)[a-zA-Z\d]{4,20}$/;
  return regex.test(userId.value);
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
  email: `${email.value}@${emailDomain.value}`,
  phone: `${phoneFirst.value}${phoneMiddle.value}${phoneLast.value}`,
  addressZipcode: `${zipcode.value}`,
  address: `${address.value}`,
  addressDetail: `${addressDetail.value}`,
  userType: userType.value,
  birthdate: birthdate.value,
  userProfileImgPath: '/testpath', // Adjust this value as needed
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


onMounted(() => {
  loadDaumPostcodeScript();
});
</script>