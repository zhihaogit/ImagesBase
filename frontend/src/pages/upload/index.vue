<template>
  <Layout>
    <el-upload
      action="/api/picture/upload"
      :on-preview="handlePreview"
      :on-remove="handleRemove"
      :file-list="fileList"
      list-type="picture"
    >
      <el-button type="primary">
        Click to upload
      </el-button>
      <template #tip>
        <div class="el-upload__tip">
          jpg/png files with a size less than 500kb
        </div>
      </template>
    </el-upload>
  </Layout>
</template>

<script lang="ts">
import Layout from "@/components/layout/index.vue";
import { ref } from "vue";
import type { UploadFile } from "element-plus/es/components/upload/src/upload.type";

export default {
  components: {
    Layout,
  },

  setup() {
    const fileList = ref([
      {
        name: "food.jpeg",
        url: "https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100",
      },
      {
        name: "food2.jpeg",
        url: "https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100",
      },
    ]);
    const handleRemove = (file: UploadFile, fileList: UploadFile[]) => {
      console.log(file, fileList);
    };
    const handlePreview = (file: UploadFile) => {
      console.log(file);
    };
    return {
      fileList,
      handleRemove,
      handlePreview,
    }
  },
};
</script>
