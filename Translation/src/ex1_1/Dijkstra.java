package ex1_1;

public class Dijkstra {  
	String path2;
    public  int[] Dijsktra(int[][] weight,int start, int end){  
     //����һ������ͼ��Ȩ�ؾ��󣬺�һ�������start����0��ţ�������������У�  
        //����һ��int[] ���飬��ʾ��start���������·������  
        int n = weight.length;        //�������  
        int[] shortPath = new int[n];    //��Ŵ�start��������������·��  
        String[] path=new String[n]; //��Ŵ�start��������������·�����ַ�����ʾ   
         for(int i=0;i<n;i++)  
             path[i]=new String(start+""+i);  
        int[] visited = new int[n];   //��ǵ�ǰ�ö�������·���Ƿ��Ѿ����,1��ʾ�����  
          
        //��ʼ������һ���������  
        shortPath[start] = 0;  
        visited[start] = 1;  
  
        for(int count = 1;count <= n - 1;count++)  //Ҫ����n-1������  
        {  
   
            int k = -1;    //ѡ��һ�������ʼ����start�����δ��Ƕ���  
            int dmin = Integer.MAX_VALUE;  
            for(int i = 0;i < n;i++)  
            {  
                if(visited[i] == 0 && weight[start][i] < dmin)  
                {  
                    dmin = weight[start][i];  
                     
                    k = i;  
                }    
                      
            }  
            //System.out.println("k="+k);  
               
            //����ѡ���Ķ�����Ϊ��������·�����ҵ�start�����·������dmin  
            shortPath[k] = dmin;  
  
            visited[k] = 1;  
    
            //��kΪ�м�㣬������start��δ���ʸ���ľ���  
            for(int i = 0;i < n;i++)  
            {                 // System.out.println("k="+k);  
                if(visited[i] == 0 && weight[start][k] + weight[k][i] < weight[start][i]){  
                     weight[start][i] = weight[start][k] + weight[k][i];  
                     
                     path[i]=path[k]+""+i;  
                      
                }  
                  
            }    
       
        }  
        path2=path[end];
         for(int i=0;i<n;i++){
        	 if(i==end){
           System.out.println("��"+start+"������"+i+"�����·��Ϊ��"+path2); 
        	 }
         }
        
        return shortPath;  
    }  
}