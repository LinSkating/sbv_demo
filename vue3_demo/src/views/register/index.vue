<script setup>
import {reactive} from "vue";
import axios from "axios";
import {ElMessage} from "element-plus";
import {useRouter} from "vue-router";
import {Female, Male} from "@element-plus/icons-vue";

const router = useRouter();


/**
 * 1. 对于表单提交<el-form>要在大的表单头绑定一个大的对象整体 eg：user （:model="user"）
 * 2. 对于表单内的每一项要绑定大对象里面的对应属性 eg：（v-model="user.username"）
 * 3. 为了在提交表单时判断用户信息是否填写完整，要在<el-form>加上（ref=“ fromRef ”）属性
 * 4. 在添加上该属性时，调用该属性名，调用validate()异步方法可以判断必填项是否填完
 */
const user = reactive({
  username: '',
  password: '',
  birthday: '',
  gender: '',
  character: []
})

/**
 * 1. 对于表单校验规则要使用一个规则对象
 * 2. 在想要校验的输入框上加上prop属性 eg：（prop="username"）
 * 3. 校验规则里的属性名要与prop属性名相同 eg：（ username: [{ 校验规则 }] ）
 */
const rules = reactive({
  username: [{ required: true, message: '请输入账号', trigger: 'blur'}],
  password: [{ required: true, message: '请输入账号', trigger: 'blur'}],
  birthday: [{ required: true, message: '请选择您的生日', trigger: 'blur'}],
  gender: [{ required: true, message: '请选择您的性别', trigger: 'blur'}]
})

async function registerHandle(formRef) {
  try {
    // 使用 formRef 来访问 el-form 实例
    if (await formRef.validate()) {
      // 如果表单验证通过，则发送注册请求
      const registerResponse = await axios.post('http://localhost:8080/user/Register', {
        username: user.username,
        password: user.password
      });

      if (registerResponse.data.code === '200') {
        ElMessage.success('注册成功');
        router.push('/login');
      } else {
        ElMessage.error('用户名已存在');
      }
    }
  } catch (error) {
    ElMessage.error('请完整填写信息');
  }
}

</script>

<template>
  <div class="mainBox flexAndCenter">
    <div class="smallBox exchangeMainAxis">
      <h1>欢迎注册</h1>
      <el-form style="max-width: 600px" label-width="auto" ref="formRef"  :rules="rules" :model="user">
        <el-form-item label="用户名" prop="username">
          <el-input v-model="user.username" placeholder="请输入用户名"/>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input v-model="user.password" placeholder="请输入密码"/>
        </el-form-item>

        <el-form-item label="birthday" prop="birthday">
          <el-col :span="11">
            <el-date-picker
                v-model="user.birthday"
                type="date"
                placeholder="请选择你的生日"
                style="width: 100%"
            />
          </el-col>
        </el-form-item>

        <el-form-item label="性别" prop="gender">
          <el-radio-group v-model="user.gender">
            <el-radio value="Boy">Boy <el-icon><Male /></el-icon> </el-radio>
            <el-radio value="Girl">Girl <el-icon><Female /></el-icon> </el-radio>
          </el-radio-group>
        </el-form-item>

        <el-form-item label="个性">
          <el-checkbox-group v-model="user.character">
            <el-checkbox value="乐观" name="type">
              乐观
            </el-checkbox>
            <el-checkbox value="外向" name="type">
              外向
            </el-checkbox>
            <el-checkbox value="情绪稳定" name="type">
              情绪稳定
            </el-checkbox>
            <el-checkbox value="聪明才智" name="type">
              聪明才智
            </el-checkbox>
            <el-checkbox value="独立" name="type">
              独立
            </el-checkbox>
            <el-checkbox value="美丽帅气" name="type">
              美丽帅气
            </el-checkbox>
            <el-checkbox value="幽默" name="type">
              幽默
            </el-checkbox>
            <el-checkbox value="自律" name="type">
              自律
            </el-checkbox>
          </el-checkbox-group>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="registerHandle">注册</el-button>
          <el-button @click="router.push('/login')">取消</el-button>
        </el-form-item>

      </el-form>
    </div>
  </div>
</template>

<style scoped>
.mainBox {
  height: 98vh;
  top: 0;
  left: 0;
  overflow: hidden;
  background: linear-gradient(135deg, #98FB98 0%, #FF7F50 100%);
}

.smallBox{
  width: 900px;
  height: 600px;
  background-color: rgba(255, 255, 255, 0.1);
  margin: 20px auto;
}

.flexAndCenter{
  display: flex;
  justify-content: center;
  align-items: center;
}

.exchangeMainAxis{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
</style>
