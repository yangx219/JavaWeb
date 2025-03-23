<script setup>

</script>

<template>
  <div class="common-layout">
    <el-container>
      <!-- Header 区域 -->
      <el-header class="header">
        <span class="title">Système de gestion auxiliaire</span>
        <span class="right_tool">
          <a href="">
            <el-icon><EditPen /></el-icon> Modifier mot de passe &nbsp;&nbsp;&nbsp; |  &nbsp;&nbsp;&nbsp;
          </a>
          <a href="">
            <el-icon><SwitchButton /></el-icon> Déconnexion
          </a>
        </span>
      </el-header>
      
      <el-container>
        <!-- 左侧菜单 Menu latéral-->
        <el-aside width="200px" class="aside">
          <!-- Barre latérale gauche -->
          <el-menu router>
            <!-- Menu d'accueil -->
            
            <el-menu-item index="/index">
              <el-icon><Promotion /></el-icon> Accueil
            </el-menu-item>

        
            
            
            <!-- Gestion des classes et des apprenants -->
            <el-sub-menu index="/manage">
              <template #title>
                <el-icon><Menu /></el-icon> Classes & Apprenants
              </template>
              <el-menu-item index="/clazz">
                <el-icon><HomeFilled /></el-icon>Gestion des classes
              </el-menu-item>
              <el-menu-item index="/stu">
                <el-icon><UserFilled /></el-icon>Gestion des apprenants
              </el-menu-item>
            </el-sub-menu>
            
            <!-- Gestion du système -->
            <el-sub-menu index="/system">
              <template #title>
                <el-icon><Tools /></el-icon> Gestion du système
              </template>
              <el-menu-item index="/dept">
                <el-icon><HelpFilled /></el-icon>Gestion des départements
              </el-menu-item>
              <el-menu-item index="/emp">
                <el-icon><Avatar /></el-icon>Gestion des employés
              </el-menu-item>
            </el-sub-menu>

            <!-- Statistiques -->
            <el-sub-menu index="/report">
              <template #title>
                <el-icon><Histogram /></el-icon> Statistiques
              </template>
              <el-menu-item index="/empReport">
                <el-icon><InfoFilled /></el-icon>Statistiques des employés
              </el-menu-item>
              <el-menu-item index="/stuReport">
                <el-icon><Share /></el-icon>Statistiques des apprenants
              </el-menu-item>
              <el-menu-item index="/log">
                <el-icon><Document /></el-icon>Statistiques des journaux
              </el-menu-item>
            </el-sub-menu>
          </el-menu>

        </el-aside>
        
        <el-main>
          
          <router-view></router-view>
        </el-main>
      </el-container>
      
    </el-container>
  </div>
</template>

<style scoped>
.header {
  background-image: linear-gradient(to right, #00547d, #007fa4, #00aaa0, #00d072, #a8eb12);
}

.title {
  color: white;
  font-size: 40px;
  font-family: 楷体;
  line-height: 60px;
  font-weight: bolder;
}

.right_tool{
  float: right;
  line-height: 60px;
}

a {
  color: white;
  text-decoration: none;
}

.aside {
  width: 220px;
  border-right: 1px solid #ccc;
  height: 730px;
}
</style>
