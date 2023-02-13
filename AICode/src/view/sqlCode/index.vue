<template>
  <div>
    <div>
      <hot-table :data="data" :rowHeaders="true" :colHeaders="true"
                 :width='750' :minRows="10" :fixedRowsStart="0"
                 style="margin: 0 auto;position: relative"
                 licenseKey="non-commercial-and-evaluation"
                 ref="hotTableComponent"
      ></hot-table>
    </div>
    <div>
      <el-input

          style="width: 600px"
          type="textarea"
          clearable
          :rows="4"
          placeholder="请输入编写要求"
          v-model="textarea">
      </el-input>
    </div>
    <el-button type="primary" style="margin: 15px auto" @click="submitData()" :loading="loading">开始编写</el-button>
    <el-button :icon="RefreshLeft" circle/>
    <div>
      <el-input
          style="width: 600px"
          disabled
          type="textarea"
          autosize
          v-model="result">
      </el-input>
    </div>
  </div>
</template>

<script setup Name="SqlCode">
import {RefreshLeft} from '@element-plus/icons-vue'
import {HotTable} from '@handsontable/vue3';
import {ElMessage} from 'element-plus'
import axios from '@/api/index.js'
import {format} from 'sql-formatter';

const hotTableComponent = ref(null)
const loading = ref(false)
const data = ref(
    [['表名', '字段1', '字段2', '字段3', '字段4', '字段5', '字段6', '字段7', '字段8', '字段9', '字段10', '字段11', '字段12', '字段13']])
onMounted(() => {

})
const textarea = ref("")
const result = ref(null)
const submitData = () => {
  let data = hotTableComponent.value.hotInstance.getData()
  data = data.splice(1)
  data = data.filter(item => {
    return item[0]
  })
  data = data.map(item => {
    let result = item.filter(obj => {
      return obj
    })
    return result
  })
  if (data.length == 0) {
    ElMessage.error('请至少填写一张表的结构，不然AI不知道怎么查询')
    return
  }
  if (textarea.value === "") {
    ElMessage.error('请填写你的要求')
    return
  }
  result.value = ''
  loading.value = true
  axios.post("/code/sqlGenerate", {data: data, text: textarea.value}).then(res => {
    //将数据保存到localStorage
    let sqlSubmitList = localStorage.getItem("sqlSubmitList");
    localStorage.setItem("sqlSubmitList", JSON.stringify([...sqlSubmitList, {
      data: hotTableComponent.value.hotInstance.getData(),
      text: textarea.value
    }]))
    console.log(sqlSubmitList)
    loading.value = false
    result.value = format(res.data.result);
  })
}

</script>

<style scoped>

</style>