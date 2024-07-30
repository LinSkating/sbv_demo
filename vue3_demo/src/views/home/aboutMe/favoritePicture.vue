<script setup>

const picturePath = Array.from({ length: 37 }, (_, index) => `/favoritePicture/${index}.jpg`);

function disappear() {
  const p = document.querySelector("p")
  p.style.display = 'none'
}
</script>

<template>
  <el-carousel
      :interval="2500"
      type="card"
      height="600px"
      style="padding-left: 75px;"
      :motion-blur="true"
      :cardScale="0.8"
  >
    <el-carousel-item v-for="item in picturePath" :key="item">
      <el-image :src="item" style="width: 464px; height: 464px" alt="666"></el-image>
    </el-carousel-item>
  </el-carousel>
  <div style="display: flex; justify-content: center">
    <p style="cursor: pointer" @click="disappear">鼠标请不要放在空白区域,知道了吗？</p>
  </div>

</template>

<style scoped>

</style>
