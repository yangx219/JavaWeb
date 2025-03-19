<script setup>
import {ref} from 'vue';

//from表单
const emp = ref({
  name: '',
  gender: '',
  job: '',
})

const search = () => {
  
}

const clear = () => {
  
}
</script>

<template>
  
  <div>
    <el-form :inline="true" :model="emp" class="demo-form-inline">
    <el-form-item label="Name">
      <el-input v-model="emp.name" placeholder="Name" clearable />
    </el-form-item>
    <el-form-item label="Gender">
      <el-select
        v-model="emp.gender"
        placeholder="Gender"
        clearable
      >
        <el-option label="Homme" value="1" />
        <el-option label="Femme" value="2" />
      </el-select>
    </el-form-item>
    <el-form-item label="Job">
      <el-select
        v-model="emp.job"
        placeholder="Pick a job"
        clearable
      >
        <el-option label="Affaires étudiantes" value="1" />
        <el-option label="Recherche académique" value="2" />
        <el-option label="Services d'emploi" value="3" />
        <el-option label="Conférencier" value="4" />
        <el-option label="Ressources humaines" value="5" />
    
      </el-select>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="search">Search</el-button>
      <el-button type="info" @click="clear">Clear all</el-button>
    </el-form-item>
  </el-form>
  </div>
  
</template>

<style scoped>

</style>
