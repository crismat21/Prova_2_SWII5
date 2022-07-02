package inventory;
 
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 *Cristiano Guimarães de Carvalho Fernandes Pinheiro CB3013111
 *Patricia Jessica Santos Fernandes Pinheiro         CB3013073
 */

public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerDAO CustomerDAO;
    private OrdersDAO OrdersDAO;
    private SalesmanDAO SalesmanDAO;
 
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        CustomerDAO = new CustomerDAO(jdbcURL, jdbcUsername, jdbcPassword);
        OrdersDAO = new OrdersDAO(jdbcURL, jdbcUsername, jdbcPassword);
        SalesmanDAO = new SalesmanDAO(jdbcURL, jdbcUsername, jdbcPassword);
 
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
 
        try {
            switch (action) {
            case "/newCustomer":
                showNewCustomer(request, response);
                break;
            case "/newSalesman":
                showNewSalesman(request, response);
                break;
            case "/newOrders":
                showNewOrders(request, response);
                break;    
            case "/insertCustomer":
                insertCustomer(request, response);
                break;
            case "/insertSalesman":
                insertSalesman(request, response);
                break;
            case "/insertOrders":
                insertOrders(request, response);
                break;
            case "/deleteSalesman":
                deleteSalesman(request, response);
                break;
            case "/deleteCustomer":
                deleteCustomer(request, response);
                break;
            case "/deleteOrders":
                deleteOrders(request, response);
                break;
            case "/editSalesman":
                showEditSalesman(request, response);
                break;
            case "/editCustomer":
                showEditCustomer(request, response);
                break;
            case "/editOrders":
                showEditOrders(request, response);
                break;
            case "/updateCustomer":
                updateCustomer(request, response);
                break;
            case "/updateSalesman":
                updateSalesman(request, response);
                break;
            case "/updateOrders":
                updateOrders(request, response);
                break;
            case "/listCustomer":
                listCustomer(request, response);
                break;
            case "/listSalesman":
                listSalesman(request, response);
                break;
            case "/listOrders":
                listOrders(request, response);
                break;
            default:
            	homePage(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
 
    private void homePage(HttpServletRequest request, HttpServletResponse response)
    		throws SQLException, IOException, ServletException {
    	RequestDispatcher dispatcher = request.getRequestDispatcher("Welcome.jsp");
        dispatcher.forward(request, response);
    }
    
    private void listCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Customer> listCustomer = CustomerDAO.listAllCustomers();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerList.jsp");
        dispatcher.forward(request, response);
    }
    
    private void listSalesman(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Salesman> listSalesman = SalesmanDAO.listAllSalesman();
        request.setAttribute("listSalesman", listSalesman);
        RequestDispatcher dispatcher = request.getRequestDispatcher("SalesmanList.jsp");
        dispatcher.forward(request, response);
    }
    
    private void listOrders(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Orders> listOrders = OrdersDAO.listAllOrders();
        request.setAttribute("listOrders", listOrders);
        RequestDispatcher dispatcher = request.getRequestDispatcher("OrdersList.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showNewCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerForm.jsp");
        dispatcher.forward(request, response);
    }
    
    private void showNewSalesman(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("SalesmanForm.jsp");
        dispatcher.forward(request, response);
    }
    
    private void showNewOrders(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("OrdersForm.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showEditSalesman(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Salesman existingSalesman = SalesmanDAO.getSalesman(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("SalesmanForm.jsp");
        request.setAttribute("salesman", existingSalesman);
        dispatcher.forward(request, response);
 
    }
    
    private void showEditCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer existingCustomer = CustomerDAO.getCustomer(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerForm.jsp");
        request.setAttribute("customer", existingCustomer);
        dispatcher.forward(request, response);
 
    }
    
    private void showEditOrders(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int ord_no = Integer.parseInt(request.getParameter("ord_no"));
        Orders existingOrders = OrdersDAO.getOrders(ord_no);
        RequestDispatcher dispatcher = request.getRequestDispatcher("OrdersForm.jsp");
        request.setAttribute("orders", existingOrders);
        dispatcher.forward(request, response);
 
    }
 
    private void insertSalesman(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        float commission = Float.parseFloat(request.getParameter("commission"));
 
        Salesman newSalesman = new Salesman(name, city, commission);
        SalesmanDAO.insertSalesman(newSalesman);
        response.sendRedirect("listSalesman");
    }
    
    private void insertCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        int grade = Integer. parseInt(request.getParameter("grade"));
        int salesman_id = Integer. parseInt(request.getParameter("salesman_id"));
 
        Customer newCustomer = new Customer(name, city, grade, salesman_id);
        CustomerDAO.insertCustomer(newCustomer);
        response.sendRedirect("listCustomer");
    }
    
    private void insertOrders(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        float purch_amt = Float.parseFloat(request.getParameter("purch_amt"));
        Date ord_date = Date.valueOf(request.getParameter("ord_date"));
        int customer_id = Integer. parseInt(request.getParameter("customer_id"));
        int salesman_id = Integer. parseInt(request.getParameter("salesman_id"));
 
        Orders newOrders = new Orders(purch_amt, ord_date, customer_id, salesman_id);
        OrdersDAO.insertOrders(newOrders);
        response.sendRedirect("listOrders");
    }
 
    private void updateSalesman(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        float commission = Float.parseFloat(request.getParameter("commission"));
 
        Salesman Salesman = new Salesman(id, name, city, commission);
        SalesmanDAO.updateSalesman(Salesman);
        response.sendRedirect("listSalesman");
    }
    
    private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        int grade = Integer.parseInt(request.getParameter("grade"));
        int salesman_id = Integer.parseInt(request.getParameter("salesman_id"));
 
        Customer Customer = new Customer(id, name, city, grade, salesman_id);
        CustomerDAO.updateCustomer(Customer);
        response.sendRedirect("listCustomer");
    }
    
    private void updateOrders(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int ord_no = Integer.parseInt(request.getParameter("ord_no"));
        float purch_amt  = Float.parseFloat(request.getParameter("purch_amt"));
        Date ord_date = Date.valueOf(request.getParameter("ord_date"));
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        int salesman_id = Integer.parseInt(request.getParameter("salesman_id"));
        
        Orders Orders = new Orders(ord_no, purch_amt, ord_date, customer_id, salesman_id);
        OrdersDAO.updateOrders(Orders);
        response.sendRedirect("listOrders");
    }
 
    private void deleteSalesman(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
 
        Salesman Salesman = new Salesman(id);
        SalesmanDAO.deleteSalesman(Salesman);
        response.sendRedirect("listSalesman");
 
    }
    
    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
 
        Customer Customer = new Customer(id);
        CustomerDAO.deleteCustomer(Customer);
        response.sendRedirect("listCustomer");
 
    }
    
    private void deleteOrders(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int ord_no = Integer.parseInt(request.getParameter("ord_no"));
 
        Orders Orders = new Orders(ord_no);
        OrdersDAO.deleteOrders(Orders);
        response.sendRedirect("listOrders");
 
    }
}