package getRequestTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class ValidateResponseCodeTest {



    @Test
    public void validateResponseCode()
    {
        RestAssured.baseURI = "https://reqres.in";
       Response responseListUsers = RestAssured.get("https://reqres.in/api/users?page=1");

       putExpectedData();
       Assert.assertTrue(responseListUsers.getStatusCode()==200);


        //Single User
       /* Response responseSingleUser = RestAssured.get("https://reqres.in/api/users/2");
        Assert.assertTrue(responseSingleUser.getStatusCode()==200);
        System.out.println("response body "+responseSingleUser.getBody().prettyPrint());
        System.out.print("response code " +responseSingleUser.asString());


        //Sinle User Not found
        Response responseSingleUserNotFound = RestAssured.get("https://reqres.in/api/users/23");
        Assert.assertTrue(responseSingleUser.getStatusCode()==404);
        System.out.print("response code " +responseSingleUser.asString());

        //List Resource
        Response responseListResource = RestAssured.get("https://reqres.in/api/users/23");
        Assert.assertTrue(responseListResource.getStatusCode()==404);
        System.out.println("response body "+responseListResource.getBody().prettyPrint());
        System.out.print("response code " +responseListResource.asString()); */

        validateData(responseListUsers);
    }
      private void validateData(Response response)
      {
          int perPage=3;
          String first_name = "George";
          String last_name = "Bluth";

          List<Map<String, ?>> actualData = response.jsonPath().getList("data");

          int dataSize = actualData.size();
          System.out.println("data size " +dataSize);
          Assert.assertTrue(dataSize == perPage);
     /*     for(int i=0; i < dataSize; i++)
          {
              System.out.print(" Using Map Id :" +actualData.get(i).get("id").toString());
              System.out.print(" Using Map Id :" +actualData.get(i).get("first_name").toString());
              System.out.print(" Using Map Id :" +actualData.get(i).get("last_name").toString());

          } */
          System.out.print(" Using Map Id :" +actualData.get(0).get("id").toString());
          Assert.assertEquals(dataSize,perPage);
          String actualFirstName = actualData.get(0).get("first_name").toString();
          System.out.print(" Using Map Id :" +actualFirstName);
          Assert.assertEquals(first_name , actualFirstName);

          String actualLastName = actualData.get(0).get("last_name").toString();
          System.out.print(" Using Map Id :" +actualLastName);
          Assert.assertEquals(last_name , actualLastName);
      }

    int putExpectedData()
    {
      /*  List<Map <String, ?>> expectedData = new List<Map<String, ?>>() {

       //     Map<String, String> map1 = new Map<String, String>;
            public int size() {
                return 0;
            }

            public boolean isEmpty() {
                return false;
            }

            public boolean contains(Object o) {
                return false;
            }

            public Iterator<Map<String, ?>> iterator() {
                return null;
            }

            public Object[] toArray() {
                return new Object[0];
            }

            public <T> T[] toArray(T[] a) {
                return null;
            }

            public boolean add(Map<String, ?> stringMap) {


                return false;
            }

            public boolean remove(Object o) {
                return false;
            }

            public boolean containsAll(Collection<?> c) {
                return false;
            }

            public boolean addAll(Collection<? extends Map<String, ?>> c) {
                return false;
            }

            public boolean addAll(int index, Collection<? extends Map<String, ?>> c) {
                return false;
            }

            public boolean removeAll(Collection<?> c) {
                return false;
            }

            public boolean retainAll(Collection<?> c) {
                return false;
            }

            public void clear() {

            }

            public Map<String, ?> get(int index) {
                return null;
            }

            public Map<String, ?> set(int index, Map<String, ?> element) {
                return null;
            }

            public void add(int index, Map<String, ?> element) {

            }

            public Map<String, ?> remove(int index) {
                return null;
            }

            public int indexOf(Object o) {
                return 0;
            }

            public int lastIndexOf(Object o) {
                return 0;
            }

            public ListIterator<Map<String, ?>> listIterator() {
                return null;
            }

            public ListIterator<Map<String, ?>> listIterator(int index) {
                return null;
            }

            public List<Map<String, ?>> subList(int fromIndex, int toIndex) {
                return null;
            }
        }

*/

        return 0;
    }
}
