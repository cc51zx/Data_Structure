package Union_Find;

public class UnionFind2 implements UF{
	private int[] parent;
	
	public UnionFind2(int size) {
		parent=new int[size];
		for(int i=0;i<size;i++)
			parent[i]=i;
	}

	@Override
	public int getSize() {
		
		return parent.length;
	}
	
	//���ҹ��̣�����Ԫ��p����Ӧ�ļ��ϱ��
	//O(h)���Ӷȣ�hΪ���ĸ߶�
	private int find(int p) {
		if(p<0 || p>parent.length)
			throw new IllegalArgumentException("p is illegal");
		while(parent[p]!=p)
			p=parent[p];
		return p;
	}
	
	//�鿴Ԫ��p��q�Ƿ�����һ������
	@Override
	public boolean isConnected(int p, int q) {
		return find(p)==find(q);
	}

	@Override
	public void unionElements(int p, int q) {
		int pRoot=find(p);
		int qRoot=find(q);
		
		if(pRoot==qRoot)
			return;
		
		parent[pRoot]=qRoot;
	}

}
