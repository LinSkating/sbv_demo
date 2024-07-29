import { ref } from 'vue'
import { defineStore } from 'pinia'

export const tempUserName = defineStore('tempUserName',()=>{
    const userName = ref('')
    function setUserName(newName) {
        userName.value = newName
    }
    return {userName, setUserName}
})
