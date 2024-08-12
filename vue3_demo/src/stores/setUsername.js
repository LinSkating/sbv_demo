import {defineStore} from "pinia";
import {ref} from "vue";

export const setUsername = defineStore('setUsername', () => {
    const curUsername = ref('')
    function setName(name) {
        curUsername.value = name
    }
    return {curUsername, setName}
})
