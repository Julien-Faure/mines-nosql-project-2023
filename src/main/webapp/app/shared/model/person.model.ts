import { PersonMinimizedModel } from "./personMinimized.model";
import { ProductModel } from "./product.model";


export class PersonModel {
  id?:number;
  name?:string;
  email?:string;
  password?:string;
  followed?:PersonMinimizedModel[];
  purchases?:ProductModel[];
}
