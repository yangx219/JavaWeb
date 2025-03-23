<script setup>
import { ref, onMounted } from 'vue'
import { ElMessage,ElMessageBox } from 'element-plus'
import { queryAllApi, addDeptApi, queryByIdApi, updateDeptApi,deleteDeptApi  } from '@/api/dept'

// Liste des départements
let deptList = ref([])

// Charger les données dynamiquement
const queryAll = async () => {
  const result = await queryAllApi()
  deptList.value = result.data
}

// Hook d'initialisation
onMounted(() => {
  queryAll()
})

// Édition d’un département - chargement des données par ID
const handleEdit = async (id) => {
  console.log(`Modifier l'élément avec l'ID ${id}`);
  formTitle.value = 'Modifier un département'
  showDialog.value = true
  deptForm.value = { name: '' }

  const result = await queryByIdApi(id)
  if (result.code) {
    deptForm.value = result.data
  }
};

const formTitle = ref('')
// Ajouter un nouveau département
const add = () => {
  formTitle.value = 'Nouveau département'
  showDialog.value = true
  deptForm.value = { name: '' }
}

// Supprimer un département - via son ID
const handleDelete = (id) => {
  console.log(`Supprimer l'élément avec l'ID ${id}`);
  
  // Lors de la suppression, afficher une boîte de confirmation
  ElMessageBox.confirm(
    'Cette action supprimera définitivement ce département. Voulez-vous continuer ?',
    'Confirmation',
    {
      confirmButtonText: 'Confirmer',
      cancelButtonText: 'Annuler',
      type: 'warning'
    }
  ).then(async () => {
    // Supprimer le département
    const result = await deleteDeptApi(id)
    if (result.code) {
      ElMessage.success('Suppression réussie')
      queryAll()
    }
  })
}


// État de la boîte de dialogue
const showDialog = ref(false)
// Données du formulaire
const deptForm = ref({ name: '' })
// Règles de validation
const formRules = ref({
  name: [
    { required: true, message: 'Veuillez saisir le nom du département', trigger: 'blur' },
    { min: 2, max: 20, message: 'Longueur entre 2 et 20 caractères', trigger: 'blur' }
  ]
})

// Référence du formulaire
const deptFormRef = ref(null)

// Réinitialiser le formulaire
const resetForm = () => {
  deptFormRef.value.resetFields()
}



// Soumettre le formulaire
const save = async () => {
  await deptFormRef.value.validate(async valid => {
    if (!valid) return
     // 提交表单
     let result = null;
    if(deptForm.value.id){
      result = await updateDeptApi(deptForm.value) // 修改
    }else {
      result = await addDeptApi(deptForm.value) // 新增
    } 
    if (result.code) {
      ElMessage.success('Opération réussie')
      showDialog.value = false
      resetForm()
      queryAll()
    } else {
      ElMessage.error(result.msg)
    }
  })
}
</script>

<template>
  <h1>Gestion des départements</h1>

  <!-- Bouton aligné à droite -->
  <el-button type="primary" @click="add()" style="float: right;">+ Nouveau département</el-button> <br><br>

  <!-- Tableau de données -->
  <el-table :data="deptList" border style="width: 100%;">
    <el-table-column type="index" label="N°" width="100" align="center" />
    <el-table-column prop="name" label="Nom du département" width="300" align="center" />
    <el-table-column prop="updateTime" label="Dernière modification" width="300" align="center" />
    <el-table-column fixed="right" label="Actions" align="center">
      <template #default="scope">
        <el-button size="small" type="primary" @click="handleEdit(scope.row.id)">Modifier</el-button>
        <el-button size="small" type="danger" @click="handleDelete(scope.row.id)">Supprimer</el-button>
      </template>
    </el-table-column>
  </el-table>

  <!-- Boîte de dialogue : nouveau ou modifier -->
  <el-dialog v-model="showDialog" :title="formTitle" width="30%" @close="resetForm">
    <el-form :model="deptForm" :rules="formRules" ref="deptFormRef">
      <el-form-item label="Nom" prop="name" label-width="80px">
        <el-input v-model="deptForm.name" autocomplete="off"></el-input>
      </el-form-item>
    </el-form>

    <template #footer>
      <span class="dialog-footer">
        <el-button @click="showDialog = false">Annuler</el-button>
        <el-button type="primary" @click="save">Valider</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<style scoped>
</style>
