import { PostOffice } from "./PostOffice";

export class ResponseDetails {
        Message: string = "Number of Post office(s) found: 21";
        Status: string = "Success";
        PostOffice: PostOffice[] = [];
}