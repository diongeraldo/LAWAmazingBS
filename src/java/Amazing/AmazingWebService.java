/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Amazing;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Dion Geraldo
 */
@WebService(serviceName = "AmazingWebService")
public class AmazingWebService {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getBookList")
    public List<Buku> getBookList() {
        DatabaseInfo db = new DatabaseInfo();
        return db.getAllBooks();
    }
}
