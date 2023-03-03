import { PersonModel } from '@/shared/model/person.model';
import axios from 'axios';

const baseApiUrl = 'api';
const databaseApiUrl = baseApiUrl + '/database';
const personApiUrl = baseApiUrl + '/person';
const requestApiUrl = baseApiUrl + '/request';

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

  public executeRequest1(username : string, depth : number): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .get(`${requestApiUrl}/1?username=${username}&depth=${depth}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public executeRequest2(userName : string, productName : string, depth : number): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .get(`${requestApiUrl}/2?username=${userName}&productName=${productName}&depth=${depth}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public executeRequest3(productName : string, depth : number): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .get(`${requestApiUrl}/3?productName=${productName}&depth=${depth}`)
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
