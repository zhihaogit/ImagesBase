export interface PictureInterface {
  useTimes: number,
  uploader: number,
  pictureName: string,
  pictureType: string,
  pictureId: string,
  pictureOrigin: Blob,
  isDelete: boolean;
}

export interface PictureListInterface {
  pictureId: string,
  url: string,
  name: string,
}
