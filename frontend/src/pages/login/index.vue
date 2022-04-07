<template>
  <div class="login-wrapper">
    <div class="login-wrapper__form">
      <div class="login-wrapper__title">
        {{ pageTitle }}
      </div>
      <el-form
        ref="loginFormRef"
        :model="loginForm"
        :rules="rules"
        :disabled="isLoginBtnLoading"
        label-position="top"
        label-width="120px"
      >
        <el-form-item
          label="Username:"
          prop="username"
        >
          <el-input v-model="loginForm.username" />
        </el-form-item>
        <el-form-item
          label="Password:"
          prop="password"
        >
          <el-input
            v-model="loginForm.password"
            show-password
            @keyup.enter="submitForm(loginFormRef)"
          />
        </el-form-item>
        <el-form-item>
          <el-button
            type="primary"
            class="login-btn"
            :loading="isLoginBtnLoading"
            @click="submitForm(loginFormRef)"
          >
            Login
          </el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script lang="ts" setup name="login">
import { reactive, ref } from "vue";
import userStoreStart from "@/store/user";
import { encode } from "js-base64";
import type { FormInstanceType } from "@/constants/type/FormInstanceType";
import { useRouter } from "vue-router";
import { RouterNameEnum } from "@/constants/enum/RouterNameEnum";

const isLoginBtnLoading = ref(false);
const userStore = userStoreStart();
const router = useRouter();
const pageTitle = "LOGIN";
const loginFormRef = ref<FormInstanceType>();
const loginForm = reactive({
  username: "",
  password: "",
});
const rules = reactive({
  username: [
    {
      required: true,
      message: "Please input username",
      trigger: "blur",
    },
  ],
  password: [
    {
      required: true,
      message: "Please input password",
      trigger: "blur",
    },
  ],
});

const submitForm = (formEl: FormInstanceType | undefined) => {
  if (!formEl || isLoginBtnLoading.value) return;
  formEl.validate((valid) => {
    if (valid) {
      isLoginBtnLoading.value = true;
      userStore
        .loginRequest(encode(JSON.stringify(loginForm)))
        .then(() => router.replace(RouterNameEnum.HOME))
        .catch((e) => Promise.reject(e))
        .finally(() => isLoginBtnLoading.value = false);
    }
  });
};
</script>

<style scoped>
.login-wrapper {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100%;
  background-color: rgb(238, 241, 246);
}

.login-wrapper__form {
  width: 400px;
  border: 1px solid #e6e6e6;
  background-color: #fff;
  padding: 20px 40px 20px;
  border-radius: 10px;
}

.login-wrapper__title {
  text-align: center;
  margin-bottom: 20px;
  font-size: 20px;
  font-weight: 800;
  color: var(--el-text-color-regular);
}

.login-btn {
  width: 100%;
}
</style>
