//trie tree, but I use sort here
#include <cstdio>
#include <cstdlib>
#include <string>
#include <cstring>

int cmp (const void *a, const void *b)
{
	return strcmp ((char *) a, (char *) b);
}

int main ()
{
	int t = 0, n = 0;
	char number[10002][13];

	scanf ("%d", &t);
	for (int i = 0; i < t; ++i)
	{
		scanf ("%d", &n);
		for (int j = 0; j < n; ++j)
		{
			scanf ("%s", number[j]);
		}
		qsort (number, n, 13 * sizeof (char), cmp);//sort

		bool b2 = 0;

		for (int j = 0; j < n; ++j)
		{
			for (int k = j + 1; k < n; ++k)//actually dont need a loop, the most similar number must be number[k+1]
			{
				int len1 = strlen (number[j]);
				int len2 = strlen (number[k]);

				if (len1 > len2)
					break;

				int l = 0;

				for (; l < len1;)
				{
					if (number[j][l] != number[k][l])
						break;
					++l;
				}
				if (l == len1)
					b2 = 1;//sign of NO
			}
		}
		if (b2)
			printf ("NO\n");
		else
			printf ("YES\n");
	}
	return 0;
}