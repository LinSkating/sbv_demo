<script setup>
import {onMounted, ref} from "vue";
import axios from "axios";
import {ElMessage} from "element-plus";

const totalPage = ref(75)
const pageSize = ref(5)
const curPage = ref(1)
const data = ref()

//注意：
//凡是用ref定义的变量，想要用它的值时要通过.value来获取
//用get请求时，要用params属性里面写要传递的值
async function fetchData() {
  try {
    const start = ( curPage.value - 1 ) * pageSize.value
    const response = await axios.get('http://localhost:8080/home/lifeSpeech', {
      params: {
        start,
        limit: pageSize.value
      }
    })
    data.value = response.data
  } catch (error) {
    console.error('Error fetching data:', error);
    ElMessage.error('无法获取数据，请检查网络连接或稍后再试。');
  }
}

function getData(page) {
  curPage.value = page
  fetchData();
}

// 在组件挂载后获取初始数据
onMounted(() => {
  fetchData();
});

</script>

<template>
    <div class="mainBox">
      <p v-for="(item) in data" :key="item.id"> {{item.sentence}} <hr> </p>
      <div>
        <el-pagination
            layout="prev, pager, next"
            :total="totalPage"
            :page-size="pageSize"
            size="large"
            @current-change="getData"
        >
        </el-pagination>
      </div>
    </div>
</template>

<style scoped>
.mainBox {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
  margin-top: 20px;
  height: 84vh;
}

p{
  padding-left: 150px;
  padding-right: 150px;
  font-size: large;
  background-color: rgba(255,255,255,0.2);
}
</style>
