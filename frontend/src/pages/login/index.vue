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
            style="width: 100%"
            @click="submitForm(loginFormRef)"
          >
            Login
          </el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script lang="ts" setup>
import { reactive, ref } from "vue";
import type { ElForm } from "element-plus";
import userStoreStart from "@/store/user";
import { encode } from 'js-base64';

const userStore = userStoreStart();

console.log(userStore)

type FormInstance = InstanceType<typeof ElForm>;

const pageTitle = "LOGIN";
const loginFormRef = ref<FormInstance>();
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

const submitForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return;
  formEl.validate((valid) => {
    if (valid) {
      userStore.loginRequest(encode(JSON.stringify(loginForm)))
    } else {
      return false;
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
</style>
