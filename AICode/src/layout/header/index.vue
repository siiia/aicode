<template>
  <el-menu
      router
      :default-active="activeIndex"
      class="menu"
      mode="horizontal"
      :ellipsis="false"
      @select="handleSelect"
  >
    <div class="logo">AICode</div>
    <el-menu-item index="/">sql编程</el-menu-item>
    <el-menu-item index="/codeUtil">
      其他工具
    </el-menu-item>
  </el-menu>
</template>

<script setup name="Header">
const activeIndex = ref('1')
const handleSelect = (key, keyPath) => {
  console.log(key, keyPath)
}
</script>
<style scoped lang="scss">

</style>

<style scoped>
.logo {
  font-size: 1.5rem;
  font-weight: 600;
  height: 100%;
  line-height: 100%;
  text-align: left;
  flex: .5;
}

.menu {
  align-items: center;
}

.menu-items {
  position: relative;
}
</style>