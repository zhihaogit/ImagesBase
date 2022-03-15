<template>
  <div class="uploader-wrapper">
    <div
      v-for="file in picturesUrlList"
      :key="file.url"
      class="uploader-item"
    >
      <img
        class="uploader-item__thumbnail"
        :src="file.url"
        :alt="file.pictureId"
      >
      <span class="uploader-item__actions">
        <span @click="handleShare(file)">
          <el-icon>
            <Share />
          </el-icon>
        </span>
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
import { ZoomIn, Download, Delete, Share } from '@element-plus/icons-vue';
import pictureStoreStart from "@/store/picture";
import copyHandler from '@/utils/copy';
import { ElMessage, ElMessageBox } from 'element-plus'
import { storeToRefs } from 'pinia';
import { PictureListInterface } from '@/constants/interface/PictureInterface';

const pictureStore = pictureStoreStart();
const { picturesUrlList } = storeToRefs(pictureStore);

const emit = defineEmits(['preview', 'delete', 'download', 'share']);

const handleRemove = (file: PictureListInterface) => {
  ElMessageBox.confirm(
    'Delete the pciture. Continue?',
    'Warning',
    {
      confirmButtonText: 'OK',
      cancelButtonText: 'Cancel',
      type: 'warning',
      center: true,
    })
    .then(() => {
      pictureStore
        .removeOnePictureRequest(file.pictureId)
        .then(() => {
          emit('delete', file);
          ElMessage({
            type: 'success',
            message: 'Delete completed',
          });
        })
        .catch(() => {
          ElMessage({
            type: 'info',
            message: 'Delete failed',
          });
        });
    })
    .catch(() => {
      ElMessage({
        type: 'info',
        message: 'Delete canceled',
      });
    });
};

const handlePictureCardPreview = (file: PictureListInterface) => {
  emit('preview', file);
};

const handleDownload = (file: PictureListInterface) => {
  emit('download', file);
  const { url, name } = file;
  downloadHanlder(url as string, name);
  ElMessage({
    message: 'Download image successfully',
    type: 'success',
  });
};

const handleShare = (file: PictureListInterface) => {
  emit('share', file);
  copyHandler(`${location.origin}${file.url}`);
  ElMessage({
    message: 'Copy image url successfully',
    type: 'success',
  });
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
  margin: 5px;
}

.uploader-item__actions:hover {
  opacity: 1;
}
</style>
