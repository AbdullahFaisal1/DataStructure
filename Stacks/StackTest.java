package Stacks;
public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(2);
        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.push(5);

        print(stack);
        replace(stack, 5, 0);
        print(stack);

        System.out.println("----------------");

        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        st1.push('C');
        st1.push('B');
        st1.push('A');

        st2.push('E');
        st2.push('D');

        print(st1);
        print(st2);

        print(Concat(st1, st2));
    }

    public static<E> void print(Stack<E> stack){
        Stack<E> temp = new Stack<>();
        while(!stack.isEmpty()){
            E val = stack.pop();
            System.out.print(val+ " ");
            temp.push(val);
        }
        System.out.println();

        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }
    }

    public static<E> void replace(Stack<E> original, E oldElement, E newElement){
        if(!original.isEmpty()){
            Stack<E> temp = new Stack<>();
            while(!original.isEmpty()){
                E val = original.pop();
                if(val.equals(oldElement))
                    val = newElement;

                temp.push(val);
            }

            while(!temp.isEmpty()){
                original.push(temp.pop());
            }
        }
    }

    public static <E> Stack<E> Concat(Stack<E> st1,Stack<E> st2){
        Stack<E> stack = new Stack<>();
        Stack<E> temp = new Stack<>();

        while(!st1.isEmpty()){
            E val = st1.pop();
            temp.push(val);
        }
        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }

        while(!st2.isEmpty()){
            E val = st2.pop();
            temp.push(val);
        }
        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }

        return stack;
    }

    public static Stack<Integer> removeElements(Stack<Integer> s1, int x){
        while(!s1.isEmpty()){
            if(s1.peak() == x){
                break;
            }
            s1.pop();
        }
        return s1;
    }

}
