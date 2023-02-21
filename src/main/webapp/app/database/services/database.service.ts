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

  public switch(type: String) {
    return new Promise((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/select?type=${type}`)
        .then(res => {
          if (res.status == 200) resolve({});
          else if (res.status == 404) reject(`Type '${res.status}' not found.`);
          else reject('Bad response status : ' + res.status);
        })
        .catch(reason => {
          reject(reason);
        });
    });
  }
}
