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
      <el-form-item label="image">
        <el-upload
          v-if="visible"
          ref="uploaderRef"
          list-type="picture-card"
          action="/api/picture/upload"
          :multiple="false"
          :headers="uploaderHeader"
          :show-file-list="true"
          :auto-upload="false"
          :limit="1"
          :data="uploadForm"
          :on-preview="handlePictureCardPreview"
          :on-change="localUploadChange"
          :on-remove="localUploadRemove"
          :on-success="remoteUploadSuccess"
          :on-error="remoteUploadError"
        >
          <template #default>
            <el-icon>
              <Plus />
            </el-icon>
          </template>
        </el-upload>
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogClose">Cancel</el-button>
        <el-button
          type="primary"
          @click="remoteUpload"
        >Upload</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script setup lang="ts" name="uploadDialog">
import Cookies from "js-cookie";
import { Plus } from '@element-plus/icons-vue';
import { reactive, ref } from 'vue';
import type { FormInstanceType } from "@/constants/type/FormInstanceType";
import type { UploadFile, UploadRawFile } from "element-plus/es/components/upload/src/upload.d";
import type { UploadInstanceType } from "@/constants/type/UploadInstanceType";
import { ElMessage } from "element-plus";

const props = defineProps({
  visible: {
    type: Boolean,
    default: false,
  },
});

const emit = defineEmits(['update:visible', 'preview', 'close']);

// eslint-disable-next-line @typescript-eslint/no-explicit-any
const uploaderHeader: any = {
  token: Cookies.get('token'),
};
const uploadFormRef = ref<FormInstanceType>();
const uploadForm = reactive({
  filename: '',
  description: '',
});
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
const resetForm = (formEl: FormInstanceType | undefined) => {
  if (!formEl) return
  formEl.resetFields()
};

const uploaderRef = ref<UploadInstanceType>()

const isAutoName = ref(false);
const currentFile = ref<UploadRawFile>();
const localUploadChange = (file: UploadFile) => {
  currentFile.value = file.raw;
  if (file.status === 'ready' && !uploadForm.filename) {
    uploadForm.filename = file.name;
    isAutoName.value = true;
  }
};

const localUploadRemove = () => {
  currentFile.value = undefined;
  if (isAutoName.value) {
    uploadForm.filename = '';
  }
};

const filenameChange = () => {
  isAutoName.value = false;
};

const remoteUploadSuccess = () => {
  ElMessage.success("Upload successfully");
  dialogClose();
};

// eslint-disable-next-line @typescript-eslint/no-explicit-any
const remoteUploadError = (error: any, file: UploadFile) => {
  const message = error.message ? JSON.parse(error.message)?.msg : 'Upload failed';
  ElMessage.error(`${error.status}: ${message}`)
  uploaderRef.value?.handleStart(file.raw);
};

const dialogClose = () => {
  emit('update:visible', false);
  emit('close');
  resetForm(uploadFormRef.value);
  uploaderRef.value?.clearFiles();
};

const remoteUpload = () => {
  uploadFormRef.value?.validate((valid) => {
    if (valid && !!currentFile.value) {
      uploaderRef.value?.submit();
    }
  });
};

const handlePictureCardPreview = (file: UploadFile) => {
  emit('preview', file);
};
</script>
