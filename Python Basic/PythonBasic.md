# Python Basic

#### Chapter.0 파이썬 시작하기

- 파이썬의 장점
  - 문법이 쉽다
  - 개발 속도가 빠르다
    - 라이브러리가 다양하다

- 파이썬의 설치
  - http://python.org/

- 파이참의 설치
  - https://www.jetbrains.com/ko-kr/pycharm/

#### Chapter.1 기본 문법

- print()
  - `print(string, int, arr, ...)`
  - `print(1, 2, 3)`
  - `print('My name is', 'JKY')

- input()
  - 입력받는 기본 명령어
  - input(String)
    - String 이후 입력 받기
  - age = input('당신의 나이는?')
    - age 변수에 입력 값 저장

- Variable
  - Type 없이 변수명으로도 가능
  - 명명규칙 : 일반적



- 참고 할 페이지

  - 파이썬 튜터(http://pythontutor.com/)

  

- DataType

  - `print( type(변수) )`

    - 변수의 타입을 출력한다

  - Numeric

    - float
    - int

  - str (String)

    >  "Hello" 또는 'hello'

    - 순서를 바꿀 수 없다?

    - 여러 줄 입력 가능

      ```python
      my_str = """안녕
      하세요
      모두들
      """
      
      '''이것도
      여러줄
      ''' 
      ```

    - String Format
      - C와 유사하지만 % 로 연결하며 여러 개인 경우 소괄호 () 사용 가능

      - format() : python에서는 주로 format() 을 사용

        ```python
        '{}'.format()
        ```

        - 값이 하나인 경우

          ```python
          'My name is %s' % 'JKY'
          'My name is {}'.format('JKY')
          ```

        - 값이 여러 개인 경우

          ```python
          '%d X %d = %d' % (2, 3, 2*3)
          '{} X {} = {}'.format(2, 3, 2*3)
          ```

        - 값의 순서를 지정

          ```
          '{2} X {0} = {1}'.format(2, 3, 2*3)
          //'6 X 2 = 3'
          ```

    - Indexing

      - String 에서 직접 index 접근 가능

          ```python
          my_name = '안H녕E하L세L요O 파이썬입니다.'
          print(my_name[3]) // E
          ```
      
          - 음수 index 는 맨 오른쪽 끝부터 -1, -2, -3, ..

              ```python
              my_name = '안H녕E하L세L요O 파이썬입니다.'
              print(my_name[-2])	// 다
              ```
      
    - Slicing

      - string[n:m]

      - index 대신 범위를 지정 ()[a:b) 의 범위)

        ```python
        my_name = '안H녕E하L세L요O 파이썬입니다.'
        print(my_name[5:7])	// L세
        ```

    - Split

      - string.split()

      - 공백 단위로 String 분할해 list 로 반환

        ```python
        my_name = '안H녕E하L세L요O 파이썬입니다.'
        print(my_name.split())	// ['안H녕E하L세L요O', '파이썬입니다.']
        ```

      - 인자를 주면 인자 기준으로 잘림

    - Docstring

      - 주석으로 사용가능한 string

      ```python
      """주석입니다"""	
      ```

  - Boolean

    - True, False : 첫 글자 대문자

- Data Structure

  - List
    
    - 대괄호 [ ] 사용
    
    ```python
    import random
    
    my_list = [1,2,3]
               print(random.choice(my_list));
    
    my_list[1] = 5
    ```
    
    - append()
    
      - 맨 뒤에 붙임
      - 자료형 관계 X
    
      ```python
      my_list = ['안녕', '뭐해', '잘가'];
      my_list.append(100);
      ```
    
      
    
  - Tuple
    `my_tuple = (1, 2, 3)`

    - 소괄호  () 사용
    - 값 변경 불가

  - Dictionary

  ```python
  my_dict = {'철수':'남', '영희':'여', '동수':'여'}
  
  print(my_dict['동수'])
  
  my_dict['동수'] = '남'
  
  print(my_dict['동수'])
  ```

- 자료형 변경 Function

  > toString, parseInt 와 비슷한 듯 하지만
  >
  > ​	변형된 자료형의 값을 return 하지 않고
  >
  > ​	스스로의 자료형을 변형시킴

  - float( 변수 )
  - int( 변수 )
  - str( 변수 )
  - list( String )
    - char list 로 변환

- Comment (주석)

  - `#` 를 사용

  ```python
  print(1+2) # 안녕
  ```

- print(' ', end = ' ')
  - end로 출력의 끝에 붙일 string을 지정 (default : "\n")
- Escape code
  - '\n'	: 줄바꿈
  - '\t'	:  탭
  - 