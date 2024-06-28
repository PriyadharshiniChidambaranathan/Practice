import java.util.ArrayList;
import java.util.List;

public class MatrixOperations {
    public static void main(String[] args)throws Exception{
        matrixImplementation m = new matrixImplementation(); 
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}}; 
        int[][] matrix1 = {{1,2,3,4},{2,4,6,8},{3,5,1,2}};
        System.out.println("Given matrix : ");
        m.print(matrix);

        int[][] transposedMatrix = m.transpose(matrix); 
        System.out.println("Transposed matrix with extra array: ");
        m.print(transposedMatrix);

        m.transposeSelf(matrix); 
        System.out.println("Transposed matrix without extra array: ");
        m.print(matrix);

        List<Integer> spiraled= m.spiralOrder(matrix);
        System.out.println("Spiraled Matrix :\n"+spiraled+"\n--------");

        boolean ispresent = m.searchSortedMatrix(matrix,5);
        System.out.println("Element ispresent in sorted matrix : "+ispresent);

        int[][] rotateclockwise = m.clockwiseRotation(matrix);
        System.out.println("Right rotated matrix in 90 deg : ");
        m.print(rotateclockwise); 

        m.clockwiseRotationSelf(rotateclockwise); 
        System.out.println("right rotated matrix without extra array: ");
        m.print(rotateclockwise);

        int[][] rotateanticlockwise = m.anticlockwiseRotation(matrix);
        System.out.println("LEft rotated matrix in 90 deg : ");
        m.print(rotateanticlockwise); 

        // m.print(matrix);

        m.anticlockwiseRotationSelf(matrix); 
        System.out.println("left rotated matrix without extra array: ");
        m.print(matrix);

        int[][] multipliedVal = m.multiply(matrix, matrix1);
        System.out.println("Product of matrices : ");
        m.print(multipliedVal);

        int[][] transposeRectangle = m.transpose_rect_matrix(matrix1);
        System.out.println("Transpose of Rectangular matrix");
        m.print(transposeRectangle);

        

        
    }
}
class matrixImplementation{

    int[][] transpose(int[][] matrix){
        int[][] result = new int[matrix.length][matrix[0].length];
        for(int i = 0;i < matrix.length; i++){
            for(int j = 0 ; j < matrix[i].length;j++){
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    void print(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.print("\n");
        }
        System.out.println("--------------\n");
    }

    void transposeSelf(int[][] matrix){
        for(int i = 0; i < matrix.length; i ++){
            for(int j = i; j < matrix[i].length; j++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;

            }
        }        
    }

    List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<Integer>();
        int r1 = 0, r2 = matrix.length-1, c1 = matrix[0].length-1, c2 = 0;

        while(r1 <= r2 && c2 <= c1  ){

          //top :
          for(int i = c2 ; i <= c1;i++){
            result.add(matrix[r1][i]);
           // System.out.print(matrix[r1][i]+" ");
          }
          r1++;

          //down:
          for(int i = r1 ; i <= r2 ;i++){
            result.add(matrix[i][c1]);
            //System.out.print(matrix[i][c1]+" ");
          }
          c1--;

          // left:
          if(r1 <= r2){
            for(int i = c1 ; i >= c2 ;i--){
            result.add(matrix[r2][i]);
            //System.out.print(matrix[r2][i]+" ");
            }
          }          
          r2--;

          //UP :
          if(c2 <= c1){
            for(int i = r2 ; i >= r1;i--){
            result.add(matrix[i][c2]);
            //System.out.print(matrix[i][c2]+" ");
            }
          }          
          c2++;

        }
        return result;
    }

    boolean searchSortedMatrix(int[][] matrix, int element){
        int r = 0, c = matrix[0].length - 1;
        while( r < matrix.length && c >= 0){
            if(matrix[r][c] == element){
                return true;
            }
            else if(matrix[r][c] > element){
                c--;
            }
            else{
                r++;
            }
        } 
        return false;
    }

    int[][] clockwiseRotation(int[][] matrix){
        int[][] result = new int[matrix.length][matrix[0].length];
        int r= matrix.length-1, c = matrix[0].length-1;
        for(int i = 0; i <=r ;i++){
            for(int j = 0; j <= c;j++){
                result[j][c-i]=matrix[i][j];
            }
        }
        return result;
    }

    void clockwiseRotationSelf(int[][] matrix){
        //transpose:
        for(int i = 0; i < matrix.length; i ++){
            for(int j = i; j < matrix[i].length; j++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;

            }
        }  

        //reverse each row:
        for(int i = 0; i <matrix.length ;i++){
            int start = 0, end = matrix.length -1;
            while(start < end){
                int temp = matrix[i][end];
                matrix[i][end] = matrix[i][start];
                matrix[i][start] = temp;
                start++;end--; 
            }
        }
    }

    int[][] anticlockwiseRotation(int[][] matrix){
        print(matrix);
        int[][] result = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i ++){
            for(int j = 0; j < matrix[i].length; j++){
                result[matrix.length - j -1][i] = matrix[i][j];
            }
        }

        return result;
    }

    void anticlockwiseRotationSelf(int[][] matrix){

        //reverse each row:
        for(int i = 0; i <matrix.length ;i++){
            int start = 0, end = matrix.length -1;
            while(start < end){
                int temp = matrix[i][end];
                matrix[i][end] = matrix[i][start];
                matrix[i][start] = temp;
                start++;end--; 
            }
        }
        //transpose:
        for(int i = 0; i < matrix.length; i ++){
            for(int j = i; j < matrix[i].length; j++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;

            }
        }  

    }


    int[][] multiply(int[][] matrix, int[][] matrix1) throws Exception{
        
        if(matrix[0].length != matrix1.length){
            throw new Exception("Invalid Matrix given .");
        }
        int result_row = matrix.length;
        int result_col = matrix1[0].length;
        int[][] result = new int[result_row][result_col];
        for(int i = 0; i < result.length ;i++){
            for(int j = 0 ; j < result[i].length; j++){
                for(int k = 0; k < matrix[0].length; k++){
                    result[i][j] += (matrix[i][k] * matrix1[k][j]);
                }
            }
        }
        return result;
    }

    int[][] transpose_rect_matrix(int[][] matrix){
        int[][] result = new int[matrix[0].length][matrix.length];
        for(int i = 0 ; i < matrix[0].length;i++){
            for(int j = 0; j < matrix.length;j++){
                result[i][j] = matrix[j][i];
            }
        }

        return result;
    } 
    
}
