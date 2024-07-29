import { ref } from 'vue'
import { defineStore } from 'pinia'

export const successStep = defineStore('successStep',()=>{
    const step = ref(0)
    function next() {
        step.value++
    }
    function reset() {
        step.value = 0
    }
    // 别忘了返回值和函数，给予暴露出去
    return {step, next, reset}
})
