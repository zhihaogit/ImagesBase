const copyHandler = (data: string) => {
  const input = document.createElement('input');
  input.setAttribute('value', data);
  document.body.appendChild(input);
  input.select();
  document.execCommand('copy');
  document.body.removeChild(input);
};

export default copyHandler;
