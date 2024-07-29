<script setup>
import {RouterView} from "vue-router";
import {successStep} from "@/stores/successStep.js";

// 使用pinia时对于仓库暴露出来的名要加() eg：successStep()
const curStep = successStep()

</script>

<template>
  <div class="mainBox">

    <div style="display: flex; width: 60%; margin-top: 30px; justify-content: center">
      <div style="width: 500px;">
        <el-steps
            style="max-width: 600px;margin-left: 100px"
            :space="200"
            :active="curStep.step"
            finish-status="success"
            process-status="process"
        >
          <el-step title="Step 1"/>
          <el-step title="Step 2"/>
          <el-step title="Step 3"/>
        </el-steps>
      </div>
    </div>

    <div>
      <RouterView/>
    </div>

  </div>
</template>

<style scoped>
.mainBox {
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 98vh;
  background-image: linear-gradient(to right, #ADD8E6 0%, #FFC0CB 100%);
}
</style>
