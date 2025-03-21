<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'

const searchEmp = ref({
  name: '',
  gender: '',
  job: '',
})

onMounted(() => {
  search();
})

const search = async () => {
  const url = `https://web-server.itheima.net/emps/list?name=${searchEmp.value.name}&gender=${searchEmp.value.gender}&job=${searchEmp.value.job}`
  const result = await axios.get(url)
  tableData.value = result.data.data
}

const clear = () => {
  searchEmp.value = { name: '', gender: '', job: '' }
  search();
}

let tableData = ref([])
</script>

<template>
  <div id="center">
    <el-form :inline="true" :model="searchEmp" class="demo-form-inline">
    <el-form-item label="Name">
        <el-input v-model="searchEmp.name" placeholder="Please enter your name!" clearable />
      </el-form-item>
      <el-form-item label="Gender">
        <el-select v-model="searchEmp.gender" placeholder="Gender" clearable>
          <el-option label="MAle" value="1" />
          <el-option label="Female" value="2" />
        </el-select>
      </el-form-item>
      <el-form-item label="Job">
        <el-select v-model="searchEmp.job" placeholder="Pick a job" clearable>
            <el-option label="Affaires étudiantes" value="1" />
            <el-option label="Recherche académique" value="2" />
            <el-option label="Services d'emploi" value="3" />
            <el-option label="Conférencier" value="4" />
            <el-option label="Ressources humaines" value="5" />

        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="search">Search</el-button>
        <el-button type="primary" @click="clear">Clear all</el-button>
      </el-form-item>
    </el-form>
    <br>

    <!-- 表格 -->
    <el-table :data="tableData" border style="width: 100%; ">
      <el-table-column prop="id" label="ID" width="80" align="center" />
      <el-table-column prop="name" label="Name" width="100" align="center" />
      <el-table-column label="Photo" width="120" align="center">
        <template #default="scope">
          <img :src="scope.row.image" width="50">
        </template>
      </el-table-column>
      <el-table-column prop="gender" label="Gender" width="120" align="center">
        <template #default="scope">
          {{ scope.row.gender == 1 ? 'male' : 'female' }}
        </template>
      </el-table-column>
      <el-table-column label="Job" width="180" align="center">
        <template #default="scope">
          <span v-if="scope.row.job == 1">Affaires étudiantes</span>
          <span v-else-if="scope.row.job == 2">Conférencier</span>
          <span v-else-if="scope.row.job == 3">Recherche académique</span>
          <span v-else>Others</span>
        </template>
      </el-table-column>
      <el-table-column prop="entrydate" label="Date of entry" width="180" align="center" />
      <el-table-column prop="updatetime" label="Update time" align="center" />
    </el-table>
  </div>
</template>

<style scoped>
#center {
  width: 70%;
  margin: auto;
  margin-top: 100px;
}
</style>