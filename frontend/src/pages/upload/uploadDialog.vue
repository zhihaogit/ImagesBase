<template>
  <el-dialog
    :model-value="props.visible"
    @update:model-value="$emit('update:visible', $event)"
    @close="dialogClose"
  >
    <el-form
      ref="uploadFormRef"
      :model="uploadForm"
      :rules="uploadrules"
      label-width="120px"
      :size="formSize"
    >
      <el-form-item
        label="filename"
        prop="filename"
      >
        <el-input
          v-model="uploadForm.filename"
          @change="filenameChange"
        />
      </el-form-item>
      <el-form-item
        label="description"
        prop="description"
      >
        <el-input
          v-model="uploadForm.description"
          type="textarea"
        />
      </el-form-item>
      <el-form-item
        label="images"
      >
        <el-upload
          ref="uploaderRef"
          action="/api/picture/upload"
          :headers="{ token: token }"
          :show-file-list="true"
          :auto-upload="false"
          :limit="1"
          list-type="picture-card"
          :on-change="localUploadChange"
          :on-remove="localUploadRemove"
          :on-success="remoteUploadSuccess"
        >
          <template #default>
            <el-icon>
              <Plus />
            </el-icon>
          </template>
        </el-upload>
      </el-form-item>
    </el-form>
  </el-dialog>
</template>

<script setup lang="ts" name="uploadDialog">
import Cookies from "js-cookie";
import { Plus } from '@element-plus/icons-vue';
import { reactive, ref } from 'vue';
import type { FormInstanceType } from "@/constants/type/FormInstanceType";
import type { UploadFile } from "element-plus/es/components/upload/src/upload.type";

const props = defineProps({
  visible: {
    type: Boolean,
    default: false,
  },
});

const emit = defineEmits(['update:visible']);

const token = Cookies.get('token');

const formSize = ref('');
const uploadFormRef = ref<FormInstanceType>();
const uploadForm = reactive({
  filename: '',
  description: '',
});
const uploaderRef = ref<UploadFile>();

const uploadrules = reactive({
  filename: [
    {
      required: true,
      message: 'Please input filename',
      trigger: 'blur',
    },
    {
      max: 100,
      message: 'Length should less than 100',
      trigger: 'blur',
    },
  ],
})

const submitForm = (formEl: FormInstanceType | undefined) => {
  if (!formEl) return
  formEl.validate((valid) => {
    if (valid) {
      
      console.log('submit!', uploaderRef.value)
    } else {
      console.log('error submit!')
      return false
    }
  })
}

const resetForm = (formEl: FormInstanceType | undefined) => {
  if (!formEl) return
  formEl.resetFields()
};

let isAutoName = false;
const localUploadChange = (file: UploadFile) => {
  if (file.status === 'ready' && !uploadForm.filename) {
    uploadForm.filename = file.name;
    isAutoName = true;
  }
  console.log(uploaderRef.value)
};

const localUploadRemove = (file: UploadFile) => {
  if (isAutoName) {
    uploadForm.filename = '';
  }
  console.log(file)
};

const filenameChange = () => {
  isAutoName = false;
};

const remoteUploadSuccess = (response: any, file: UploadFile) => {
  console.log(response, file)
};

const dialogClose = () => {
  emit('update:visible', false);
};
</script>
