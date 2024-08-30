import {defineStore} from "pinia";
import {ref} from "vue";

export const getTimeTravelDetail = defineStore('getTimeTravelDetail', () => {
    const curItem = ref({})
    function setCurItem(item) {
        curItem.value = item
    }
    return {curItem, setCurItem}
})
