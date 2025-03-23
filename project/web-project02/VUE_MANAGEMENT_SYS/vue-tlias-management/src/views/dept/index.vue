<script setup> 
import { ref, onMounted } from 'vue'
import {queryAllApi} from '@/api/dept'

// Liste des départements
let deptList = ref([])

// Requête pour charger les départements
//动态加载数据-查询部门
const queryAll = async () => {
  const result = await queryAllApi()
  deptList.value = result.data
}

// Hook de montage
onMounted(() => {
  queryAll()
})

// Modifier un département (édition)
const handleEdit = (id) => {
  console.log(`Modifier le département avec l'ID ${id}`);
  // Implémenter la logique de modification ici
}

// Supprimer un département
const handleDelete = (id) => {
  console.log(`Supprimer le département avec l'ID ${id}`);
  // Implémenter la logique de suppression ici
}
</script>

<template>
  <h1>Gestion des départements</h1>

  <!-- Bouton aligné à droite -->
  <el-button type="primary" @click="handleEdit" style="float: right;"> + Nouveau département</el-button> <br><br>

  <el-table :data="deptList" border style="width: 100%;">
    <el-table-column type="index" label="N°" width="100" align="center" />
    <el-table-column prop="name" label="Nom du département" width="300" align="center" />
    <el-table-column prop="updateTime" label="Dernière modification" width="300" align="center" />
    <el-table-column fixed="right" label="Actions" align="center">
      <template #default="scope">
        <el-button type="primary" size="small" @click="handleEdit(scope.row.id)"><el-icon><EditPen /></el-icon>Modifier</el-button>
        <el-button size="small" type="danger" @click="handleDelete(scope.row.id)"><el-icon><Delete /></el-icon>Supprimer</el-button>
      </template>
    </el-table-column>
  </el-table>


  <!-- 新增部门的对话框 -->
  <el-dialog v-model="showDialog" :title="formTitle" width="30%" @close="resetForm">
    <el-form :model="deptForm" :rules="formRules" ref="deptFormRef">
      <el-form-item label="部门名称" prop="name" label-width="80px">
        <el-input v-model="deptForm.name" autocomplete="off"></el-input>
      </el-form-item>
    </el-form>

    <template #footer>
      <span class="dialog-footer">
        <el-button @click="showDialog = false">取消</el-button>
        <el-button type="primary" @click="save">确定</el-button>
      </span>
    </template>
  </el-dialog>

  
</template>



<style scoped>
</style>
