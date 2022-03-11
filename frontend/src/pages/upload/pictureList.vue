<template>
  <div class="uploader-wrapper">
    <div
      v-for="file in pictureStore.picturesUrlList"
      :key="file.url"
      class="uploader-item"
    >
      <img
        class="uploader-item__thumbnail"
        :src="file.url"
        :alt="file.url"
      >
      <span class="uploader-item__actions">
        <span @click="handlePictureCardPreview(file)">
          <el-icon>
            <zoom-in />
          </el-icon>
        </span>
        <span @click="handleDownload(file)">
          <el-icon>
            <Download />
          </el-icon>
        </span>
        <span @click="handleRemove(file)">
          <el-icon>
            <Delete />
          </el-icon>
        </span>
      </span>
    </div>
  </div>
</template>

<script setup lang="ts" name="ListItem">
import downloadHanlder from '@/utils/download';
import { ZoomIn, Download, Delete } from '@element-plus/icons-vue';
import type { UploadFile } from 'element-plus/es/components/upload/src/upload.type';
import pictureStoreStart from "@/store/picture";

const pictureStore = pictureStoreStart();

const emit = defineEmits(['preview', 'delete', 'download']);

const handleRemove = (file: UploadFile) => {
  emit('delete', file);
};
const handlePictureCardPreview = (file: UploadFile) => {
  emit('preview', file);
};
const handleDownload = (file: UploadFile) => {
  emit('download', file);
  const { url, name } = file;
  downloadHanlder(url as string, name);
};
</script>

<style scoped>
.uploader-wrapper {
  height: calc(100% - 40px);
  overflow-y: auto;
}

.uploader-item {
  overflow: hidden;
  background-color: #fff;
  border: 1px solid #c0ccda;
  border-radius: 6px;
  box-sizing: border-box;
  width: 148px;
  height: 148px;
  margin: 8px;
  display: inline-block;
  position: relative;
}

.uploader-item__thumbnail {
  width: 100%;
  height: 100%;
  /* 保持缩放比 */
  object-fit: contain;
}

.uploader-item__actions {
  display: flex;
  align-items: center;
  justify-content: center;
  position: absolute;
  width: 148px;
  height: 148px;
  left: 0;
  top: 0;
  cursor: default;
  text-align: center;
  color: #fff;
  opacity: 0;
  font-size: 20px;
  background-color: #00000080;
  transition: opacity var(--el-transition-duration);
}

.uploader-item__actions span {
  display: inline-block;
  cursor: pointer;
  margin: 10px;
}

.uploader-item__actions:hover {
  opacity: 1;
}
</style>
