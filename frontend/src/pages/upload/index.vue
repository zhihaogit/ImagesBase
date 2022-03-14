<template>
  <Layout>
    <el-button
      type="primary"
      class="upload-btn"
      @click="uploadVisible = true"
    >
      Upload
    </el-button>
    <PictureList
      @preview="handlePictureCardPreview"
    />
  </Layout>
  <PreviewDialog
    v-model:visible="previewVisible"
    v-model:url="previewImageUrl"
  />
  <UploadDialog
    v-model:visible="uploadVisible"
    @preview="handlePictureCardPreview"
    @close="uploadDialogClose"
  />
</template>

<script lang="ts" setup name="upload">
import Layout from "@/components/layout/index.vue";
import PreviewDialog from '@/components/picturePreview/index.vue';
import PictureList from './pictureList.vue';
import UploadDialog from './uploadDialog.vue';
import pictureStoreStart from "@/store/picture";
import { ref } from "vue";
import type { UploadFile } from "element-plus/es/components/upload/src/upload.type";

const previewImageUrl = ref('');
const previewVisible = ref(false);
const uploadVisible = ref(false);
const pictureStore = pictureStoreStart();

const handlePictureCardPreview = (file: UploadFile) => {
  previewVisible.value = true;
  previewImageUrl.value = file.url as string;
};

const uploadDialogClose = () => {
  pictureStore.getAllPicturesRequest();
};

// 获取图片列表
pictureStore.getAllPicturesRequest();
</script>

<style scoped>
.upload-btn {
  margin: 8px 0 0 8px;
}
</style>
