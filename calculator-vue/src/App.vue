<script>
export default {
  data() {
    return {
      operand1: 0,
      operand2: 0,
      operator: '+',
      result: 0
    };
  },
  methods: {
    calculate() {
      const requestBody = {
        operand1: this.operand1,
        operand2: this.operand2,
        operator: this.operator
      };

      fetch('http://localhost:8080/api/calculator/calculate', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Access-Control-Allow-Origin': '*'
        },
        body: JSON.stringify(requestBody)
      })
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then(data => {
        this.result = data.result;
      })
      .catch(error => {
        console.error('Error:', error);
      });
    }
  }
};
</script>

<template>
  <div>
    <h1>Calculadora Marte</h1>
    <div>
      <label for="operand1">Operando 1:</label>
      <input type="number" v-model="operand1" id="operand1" />
    </div>
    <div>
      <label for="operator">Operador:</label>
      <select v-model="operator" id="operator">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
      </select>
    </div>
    <div>
      <label for="operand2">Operando 2:</label>
      <input type="number" v-model="operand2" id="operand2" />
    </div>
    <div>
      <button @click="calculate">Calcular</button>
    </div>
    <div>
      <p>Resultado: {{ result }}</p>
    </div>
  </div>
</template>

<style scoped>
</style>
