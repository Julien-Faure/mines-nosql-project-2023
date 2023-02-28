import { PersonModel } from '@/shared/model/person.model';
import axios from 'axios';

const databaseApiUrl = 'api/database';
const personApiUrl = 'api/person';

export default class DatabaseService {

  public listPerson(): Promise<PersonModel[]> {
    return new Promise<any>((resolve, reject) => {
      axios
        .get(personApiUrl)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public list(): Promise<String[]> {
    return new Promise<any>((resolve, reject) => {
      axios
        .get(databaseApiUrl)
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
        .post(`${databaseApiUrl}/select?type=${type}`)
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
