<script setup>
import { ref } from 'vue'
import { loginApi } from '@/api/login'
import { ElMessage } from 'element-plus'
import { useRouter } from 'vue-router'

let loginForm = ref({ username: '', password: '' })
let router = useRouter()

// Connexion
const login = async () => {
  const result = await loginApi(loginForm.value)
  if (result.code) {
    ElMessage.success('Connexion réussie')
    localStorage.setItem('loginUser', JSON.stringify(result.data))
    router.push('/')
  } else {
    ElMessage.error(result.msg)
  }
}

// Réinitialiser
const clear = () => {
  loginForm.value = {
    username: '',
    password: ''
  }
}
</script>

<template>
  <div id="container">
    <div class="login-form">
      <el-form label-width="100px">
        <p class="title">Système de gestion auxiliaire</p>

        <el-form-item label="Utilisateur" prop="username">
          <el-input v-model="loginForm.username" placeholder="Veuillez saisir le nom d'utilisateur"></el-input>
        </el-form-item>

        <el-form-item label="Mot de passe" prop="password">
          <el-input type="password" v-model="loginForm.password" placeholder="Veuillez saisir le mot de passe"></el-input>
        </el-form-item>

        <el-form-item>
          <el-button class="button" type="primary" @click="login">Connexion</el-button>
          <el-button class="button" type="info" @click="clear">Réinitialiser</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<style scoped>
#container {
  padding: 10%;
  height: 410px;
  background-image: url('../../assets/bg1.jpg');
  background-repeat: no-repeat;
  background-size: cover;
}

.login-form {
  max-width: 500px;
  padding: 30px;
  margin: 0 auto;
  border: 1px solid #e0e0e0;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
  background-color: white;
}

.title {
  font-size: 30px;
  font-family: '楷体', serif;
  text-align: center;
  margin-bottom: 30px;
  font-weight: bold;
}

.button {
  margin-top: 30px;
  width: 120px;
}
</style>
