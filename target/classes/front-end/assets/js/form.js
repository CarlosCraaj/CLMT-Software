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
