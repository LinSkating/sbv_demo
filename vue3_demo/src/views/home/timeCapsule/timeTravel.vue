<script setup>
import {onMounted, ref} from "vue";
import axios from "axios";
import {ChatDotRound, Refresh, Star, StarFilled, View} from "@element-plus/icons-vue";
import {setUsername} from "@/stores/setUsername.js";

const content = ref([])
const limit = ref(6)
const curUser = setUsername()
async function fetchTimeTravelContent() {
  try {
    const response = await axios.get('http://localhost:8080/home/timeTravel', {
      params: {
        limit: limit.value,
        reader: curUser.curUsername
      }
    })
    content.value = response.data
  } catch (error) {
    console.log('Error fetching data:', error)
  }
}

onMounted(async () => {
  await fetchTimeTravelContent()
})

const gradient = ['gradient-dawn', 'gradient-sunset', 'gradient-forest', 'gradient-ocean',
  'gradient-night', 'gradient-spring']

function getGradient(index) {
  return gradient[index]
}

axios.defaults.headers.common['Content-Type'] = 'application/json'
async function handleLike(item) {
  if (item.author !== curUser.curUsername) {
    item.likeStatus = !item.likeStatus
    try {
      await axios.put('http://localhost:8080/home/timeTravel/updateLikeStatus', {
        //请求体
        id: item.id,
        reader: curUser.curUsername,
        author: item.author,
        works: item.sentence,
        likeStatus: item.likeStatus
      })
      if (item.likeStatus) {
        item.star++;
      } else {
        item.star--;
      }
    } catch (error) {
      console.error('Error updating like status:', error);
      // 如果发生错误，恢复原来的点赞状态
      item.likeStatus = !item.likeStatus;
      if (item.likeStatus) {
        item.star--;
      } else {
        item.star++;
      }
    }
  }
}
</script>

<template>
  <div style="display: flex; flex-wrap: wrap; justify-content: space-around; margin-top: 30px; ">
    <div class="boxSize" v-for="(item,index) in content" :key="item.id" :class="getGradient(index)"
         style="border-radius: 20px">
      <div style="margin-left: 20px">
        <h4>作者：{{ item.author }}</h4>
      </div>
      <div style="display: flex; justify-content: center">
        <p>{{ item.sentence }}</p>
      </div>
      <div style="display: flex; justify-content: end">
        <div class="setMargin" @click="handleLike(item)">
          <el-icon v-if="item.likeStatus">
            <StarFilled/>
          </el-icon>
          <el-icon v-else>
            <Star/>
          </el-icon>
          {{ item.star }}
        </div>
        <div class="setMargin">
          <el-icon>
            <View/>
          </el-icon>
          {{ item.view }}
        </div>
        <div class="setMargin">
          <el-icon>
            <ChatDotRound/>
          </el-icon>
          {{ item.common }}
        </div>
      </div>
    </div>
  </div>
  <div style="display:flex; justify-content: center;">
    <el-button :icon="Refresh" size="large" type="primary" plain @click="fetchTimeTravelContent">换一批</el-button>
  </div>
</template>

<style scoped>
.boxSize {
  width: 300px;
  height: 230px;
  margin-bottom: 25px;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  transition: transform 0.3s ease;
}

.boxSize:hover {
  transform: scale(1.05);
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

.setMargin {
  margin: 0 7px;
}

.gradient-dawn {
  background-image: linear-gradient(to right, #F4D03F, #F9E79F, #F5EAD7);
}

.gradient-sunset {
  background-image: linear-gradient(to right, #FF6B6B, #FCAE91, #F39C12);
}

.gradient-forest {
  background-image: linear-gradient(to right, #389826, #7FB335, #8AC926);
}

.gradient-ocean {
  background-image: linear-gradient(to right, #1B667F, #52B69A, #9CECFB);
}

.gradient-night {
  background-image: linear-gradient(to right, #3D5AF1, #5370F2, #29BBFF);
}

.gradient-spring {
  background-image: linear-gradient(to right, #F4D03F, #D3D3D3, #82E0AA);
}
</style>
