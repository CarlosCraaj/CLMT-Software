window.onload = () =>
   document.querySelector('form').addEventListener('submit', (e) => {
      e.preventDefault();
      const submitFormElement = document.querySelector('form');
      console.log('submitFormElement', submitFormElement);
      const formData = new FormData(submitFormElement);
      const formProps = Object.fromEntries(formData);
      console.log('formData', formData);
      console.log('formProps', formProps);
   });

async function sendAnswer(user_id, data) {
   let url = 'locals/user_register/';
   let urlDev = 'localhost:3000/user_register';
   await fetch(urlDev, {
      method: 'POST',
      headers: '',
      body: data,
   });
   try {
      console.log('sucesso!');
      return response;
   } catch (error) {
      console.log('erro na resposta:', error);
   }
}
