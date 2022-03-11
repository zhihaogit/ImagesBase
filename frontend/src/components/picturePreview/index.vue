<template>
  <el-dialog
    :model-value="props.visible"
    @update:model-value="$emit('update:visible', $event)"
    @close="dialogClose"
  >
    <img
      :src="props.url"
      :alt="props.url"
      class="picture-preview__image"
    >
  </el-dialog>
</template>

<script setup lang="ts" name="PreviewDialog">
const props = defineProps({
  visible: {
    type: Boolean,
    default: false,
  },

  url: {
    type: String,
    default: '',
  },
});
const emit = defineEmits(['update:visible', 'update:url']);

const dialogClose = () => {
  emit('update:visible', false);
  emit('update:url', '');
};
</script>

<style>
.picture-preview__image {
  width: 680px;
  height: 100%;
}
</style>
