import axios from 'axios';

const baseApiUrl = 'api/database';

export default class DatabaseService {
  public list(): Promise<String[]> {
    return new Promise<any>((resolve, reject) => {
      axios
        .get(baseApiUrl)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
