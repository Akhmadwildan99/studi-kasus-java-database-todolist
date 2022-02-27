import java.util.Scanner;

public class JavaTodoList {
    public static String[] model = new String[10];

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    /**
     * method show todo list;
     */
    public static void showTodoList() {
        System.out.println("TODO LIST");
        for (var i = 0; i < model.length; i++){
            if(model[i] != null){
                System.out.println(i + 1 + ". " + model[i]);
            }
        }
    }

    // test show todo list
    public static void testShowTodoList(){
        model[0] = "satu";
        model[1] = "dua";
        model[2] = "tiga";

        showTodoList();
    }

    /**
     *
     *  method add todo list;
     */
    public static void addTodoList(String todo){
        var isFull = true;
        for (var i = 0; i < model.length; i++){
            //Jika array masih ada yang kosong
            if(model[i] == null){
                model[i] = todo;
                isFull = false;
                break;
            }
        }

        // Jika array penuh resize array menjadi 2 x lipat.

        if(isFull){
            var temp = model;
            model = new String[model.length * 2];
           for (var i = 0; i < temp.length; i++){
               model[i] = temp[i];
           }

            //Tambahkan todo ke array yang masih kosong

            for (var i = 0; i < model.length; i++){

                //Jika array masih ada yang kosong

                if(model[i] == null){
                    model[i] = todo;
                    break;
                }
            }
        }
    }

    // test add todo list;
    public static void testAddTodoList(){
        for (var i = 0; i < 100; i++){
            addTodoList("contoh todo ke " + i);
        }

        showTodoList();
    }

    /**
     * method remove todo list;
     * @param number untuk menghapus todo list;
     * @return true jika berhasil, false jika gagal
     */
    public static boolean removeTodoList(int number){
        if((number - 1) >= model.length){
            return false;
        } else if(model[number - 1] == null){
            return false;
        } else {
            for(var i = number - 1; i < model.length; i++) {
                if(i == model.length - 1){
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }


    // Test remove todo list.

    public static void testRemoveTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");

        var result = removeTodoList(2);
        System.out.println(result);

        result = removeTodoList(5);
        System.out.println(result);

        showTodoList();
    }

    /**
     *
     * @param number index todo yang akan di update
     * @param todo yang akan di input untk menggantikan todo yang lama
     * @return true jika berhasil, false jika gagal
     */

    public static boolean updateTodoList(int number, String todo){
        if(number - 1 >= model.length){
            return false;
        } else if(model[number - 1] == null){
            return false;
        } else {
            model[number - 1] = todo;
            return true;
        }
    }

    // Test update todo List
    public static  void testUpdateTodoList(){
        addTodoList("membaca");
        addTodoList("coding");
        addTodoList("makan");

        var result = updateTodoList(1, "sarapan");
        System.out.println(result);

        result = updateTodoList(4, "buang air besar");
        System.out.println(result);

        result = updateTodoList(20, "minum");
        System.out.println(result);

        showTodoList();
    }


    public static String input(String info){
        System.out.print(info);
        var data = scanner.nextLine();
        return data;
    }


    // Test input method

    public static void testInput(){
        var name = input("name ");
        System.out.println("Hi " + name);

        var team = input("team ");
        System.out.println("team " + team);
    }


    /**
     * menampilkan show todo list
     */

    public static void viewShowTodoList(){
        while (true){
            showTodoList();

            System.out.println("MENU: ");
            System.out.println("1. tambah");
            System.out.println("2. update");
            System.out.println("3. hapus");
            System.out.println("x. keluar");

            var input = input("pilih: ");
            if(input.equals("1")){
                viewAddTodoList();
            } else if(input.equals("2")){
                viewUpdateTodoList();
            } else if(input.equals("3")){
                viewReamoveTodoList();
            } else if(input.equals("x")){
                break;
            } else{
                System.out.println("Pilihan tidak dimengerti.");
            }
        }
    }

    public static void testViewShowTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");

        viewShowTodoList();
    }


    /**
     * menampilkan tambah todo list
     */
    public static void viewAddTodoList(){
        System.out.println("MENAMBAH TODO LIST");

        var todo = input("input todo (x jika batal): ");

        if(todo.equals("x")){
            //batal
        } else{
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");

        viewAddTodoList();

        showTodoList();
    }


    /**
     * menampilkan update todo list
     */
    public static void viewUpdateTodoList(){
        System.out.println("Update Todo List:");

        var index = input("index (x jika batal): ");
        var todo = input("todo (x jika batal): ");

        if(index.equals("x") || todo.equals("x")){
            //batal
        } else{
            var success = updateTodoList(Integer.valueOf(index), todo);
            if(!success){
                System.out.println("Gagal update todo list!");
            }
        }
    }

    public static void testViewUpdateTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");

        viewUpdateTodoList();

        showTodoList();
    }

    /**
     * menampilkan hapus todo list
     */
    public static void viewReamoveTodoList(){
        System.out.println("Mengahpaus Todo List:");

        var index = input("index (x jika batal): ");

        if(index.equals("x")){
            //batal
        } else {
            var success = removeTodoList(Integer.valueOf(index));
            if(!success){
                System.out.println("Gagal menghapus Todo List!");
            }
        }
    }

    public static void testViewRemoveTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");

        viewReamoveTodoList();

        showTodoList();
    }

}
