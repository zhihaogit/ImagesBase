/**
 * 文件下载函数
 * 
 * @param url 
 * @param filename 
 * @param type 可选参数：filename不带文件类型，则需要传个类型
 */
const downloadHanlder = (url: string, filename: string, type?: string): void => {
  const fullName =  type ? `${filename}.${type}` : filename;
  const a = document.createElement('a');
  a.setAttribute('href', url);
  a.setAttribute('download', fullName);
  a.setAttribute('style', 'display: none');
  document.body.appendChild(a);
  a.click();
  document.body.removeChild(a);
};

export default downloadHanlder;