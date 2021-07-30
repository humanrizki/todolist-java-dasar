public class AplikasiTodolist {
    public static String[] model = new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args){
//        testAddTodolist();
//          testRemoveTodolist();
        viewShowTodolist();
    }
    /*
        Menampilkan Todolist
    */
    public static void showTodolist(){
        var i = 1;
        System.out.println("Todolist");
        for(var todo : model){
            if(todo != null){
               System.out.println(i + ". " + todo);
               i++;
            }
        }
    }
    public static void testShowTodolist(){
        model[0] = "Belajar Java Dasar";
        model[1] = "Belajar Java OOP";
        model[2] = "Belajar Java Dasar Todolist";
        showTodolist();
    }
    /*
       Menambah todo ke list
     */
    public static void addTodolist(String todo){
       var isFull = true;
       for(var i = 0; i < model.length; i++){
           if(model[i] == null){
               isFull = false;
               break;
           }
       }
       if(isFull){
           var temp = model;
           model = new String[model.length * 2];
           for(var i = 0; i < temp.length; i++){
               model[i] = temp[i];
           }
       }
       for(var i = 0; i < model.length; i++){
           if(model[i] == null){
               model[i] = todo;
               break;
           }
       }
    }
    public static void testAddTodolist(){
        addTodolist("Belajar Java Dasar");
        addTodolist("Belajar Java OOP");
        addTodolist("Belajar Java Database");
        addTodolist("Belajar Java Generic");
        addTodolist("Belajar Java Collection");
        showTodolist();
        
    }
    /*
     Menghapus todolist
    */
    public static boolean removeTodolist(Integer number){
        if((number - 1) >= model.length){
            return false;
        } else if(model[number - 1] == null){
            return false;
        } else {
            for(var i = (number - 1); i < model.length; i++){
                if(i == (model.length - 1)){
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    } 
    public static boolean updateTodolist(Integer number){
        
        if((number - 1) >= model.length){
            return false;
        } else if(model[number - 1] == null){
            return false;
        } else {
            for(var i = (number - 1); i < model.length; i++){
                if(i == (number - 1)){
                    var todo = input("Ganti String");
                    model[i] = todo;
                    break;
                }
            }
            return true;
        }
    }
    public static void testUpdateTodolist(){
        addTodolist("Satu");
        addTodolist("Dua");
        addTodolist("Tiga");
        showTodolist();
        var no = input("pilih");
        updateTodolist(Integer.valueOf(no));
        showTodolist();
    }
    public static void testRemoveTodolist(){
        addTodolist("Satu");
        addTodolist("Dua");
        addTodolist("Tiga");
        var result = removeTodolist(2);
        System.out.println(result);
        showTodolist();
        result = removeTodolist(2);
        System.out.println(result);
        showTodolist();
        
    }
    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }
    public static void testInput(){
        String nama = input("Nama");
        System.out.println(nama);
    }
    /*
        Menampilkan view show todolist
    */
    public static void viewShowTodolist(){
        while(true){    
            showTodolist();
            System.out.println("Menu : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("3. Ubah");
            System.out.println("4. Keluar");

            var input = input("pilih");
            if(input.equals("1")){
                viewAddTodolist();
            } else if(input.equals("2")){
                viewRemoveTodolist();
            } else if (input.equals("3")){
                viewUpdateTodolist();
            }else if(input.equals("4")){
                break;
            } else {
                System.out.println("Pilihan Tidak dimengerti");
            }
        }
    }
    /*
        Menambah view todolist
    */
    public static void testViewShowTodolist(){
        addTodolist("Satu");
        addTodolist("Dua");
        addTodolist("Tiga");
        addTodolist("Empat");
        addTodolist("Lima");
        viewShowTodolist();
    }
    public static void viewAddTodolist(){
        System.out.println("MENAMBAH TODOLIST");
        var todo = input("X = Batal");
        if(todo.equals("x") || todo.equals("X")){
//            viewShowTodolist();
        } else {
            addTodolist(todo);
        }
    } 
    public static void testViewAddTodolist(){
        addTodolist("Satu");
        addTodolist("Dua");
        addTodolist("Tiga");
        addTodolist("Empat");
        addTodolist("Lima");
        showTodolist();
        viewAddTodolist();
        showTodolist();
    }
    /*
        View menghapus todolist
    */
    public static void viewRemoveTodolist(){
        System.out.println("MENGHAPUS TODOLIST");
        var todo = input("Pilih (x) = Batal");
        if(todo.equals("x") || todo.equals("X")){
//            viewShowTodolist();
        } else {
            var success = removeTodolist(Integer.parseInt(todo));
            if(!success){
                System.out.println("Gagal Menghapus Todolist : " + todo);
            }
        }
    }
    public static void testViewRemoveTodolist(){
        addTodolist("Satu");
        addTodolist("Dua");
        addTodolist("Tiga");
        showTodolist();
        viewRemoveTodolist();
        showTodolist();
    }
    public static void viewUpdateTodolist(){
        System.out.println("MENGUBAH TODOLIST");
        var no = input("Pilih (x) = Batal");
        var success = true;
        if(no.equals("x") || no.equals("X")){
            viewShowTodolist();
        } else {
            success = updateTodolist(Integer.valueOf(no));
            if(!success){
                System.out.println("Gagal Mengubah Todolist : " + no);
            }
        }
    }
    public static void testViewUpdateTodolist(){
        addTodolist("Satu");
        addTodolist("Dua");
        addTodolist("Tiga");
        showTodolist();
        viewUpdateTodolist();
        showTodolist();
    }
}
