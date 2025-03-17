<script setup>

//introduire ref
import {onMounted, ref} from 'vue';

//declare response data
const count = ref(0);

//declare fonction
function increment (){
    count.value++;
}

//Declare hook function
onMounted(() =>{
    console.log('Vue mounted ...')
})


</script>

<template>
    <button @click="increment">
        count : {{ count }}
    </button>
</template>

<style scoped>
</style>