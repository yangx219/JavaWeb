<script setup> 
import { ref, onMounted } from 'vue'
import axios from 'axios'

// Liste des départements
let deptList = ref([])

// Requête pour charger les départements
const queryAll = async () => {
  const result = await axios.get('http://127.0.0.1:4523/m1/6079046-5769439-default/depts')
  deptList.value = result.data.data
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
</template>

<style scoped>
</style>
